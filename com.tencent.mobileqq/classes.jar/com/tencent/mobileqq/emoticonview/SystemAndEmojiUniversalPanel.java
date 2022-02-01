package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqemoticon.api.ISystemAndEmojiPanelService.DispatchKeyEventListener;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.List;

public class SystemAndEmojiUniversalPanel
  extends RelativeLayout
  implements View.OnClickListener, IEmoticonPanel
{
  private static final int PRELOAD_LINE_NUM = 5;
  private static final String TAG = "EmoticonUniversalPanel";
  private float density;
  private EmoticonCallback mCallback;
  private ImageButton mDeleteButton;
  private ISystemAndEmojiPanelService.DispatchKeyEventListener mDispatchKeyEventListener;
  private EmotionPanelListView mEmotionPanelListView;
  private boolean mFilterSysFaceBeyond255Enable = false;
  private EditText mInputEdit;
  private EmotionPanelInfo mPanelInfo;
  private boolean mShowDescribeInPreview = false;
  private SystemAndEmojiAdapter mSystemAndEmojiAdapter;
  private int mainPanelWidth;
  private int minAlphaLeft;
  private int minAlphaTop;
  private boolean multiWindowMode;
  private int[] point = new int[2];
  private int rowCount = 7;
  private boolean showCommonUsedSystemEmoji = false;
  private int spacing;
  private TextWatcher textWatcher = new SystemAndEmojiUniversalPanel.3(this);
  
  public SystemAndEmojiUniversalPanel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SystemAndEmojiUniversalPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SystemAndEmojiUniversalPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void asyncLoadData(int paramInt)
  {
    ThreadManager.post(new SystemAndEmojiUniversalPanel.1(this, paramInt), 5, null, true);
  }
  
  private int getColumnNum()
  {
    int j = this.mPanelInfo.columnNum;
    int i = j;
    if (this.multiWindowMode)
    {
      j = Math.max(1, j * 4 / 7);
      i = j;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("multiWindowMode: ");
        localStringBuilder.append(this.mPanelInfo.columnNum);
        localStringBuilder.append("->");
        localStringBuilder.append(j);
        QLog.d("EmoticonUniversalPanel", 2, localStringBuilder.toString());
        i = j;
      }
    }
    return i;
  }
  
  private int getLastItemAddPaddingBottom()
  {
    if (isShowDeleteButton()) {
      return this.mDeleteButton.getMeasuredHeight();
    }
    return 0;
  }
  
  private boolean isShowDeleteButton()
  {
    ImageButton localImageButton = this.mDeleteButton;
    return (localImageButton != null) && (localImageButton.getVisibility() == 0);
  }
  
  private void preloadSystemEmotion(List<EmotionPanelData> paramList, ListView paramListView)
  {
    if ((paramListView != null) && (paramList != null) && (paramList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonUniversalPanel", 2, "onScrollStateChanged preload systemEmotion");
      }
      int k = paramListView.getFirstVisiblePosition();
      int j = (paramListView.getLastVisiblePosition() + 1) * 7;
      int i = j;
      while ((i < j + 35) && (i < paramList.size()))
      {
        paramListView = (EmotionPanelData)paramList.get(i);
        if ((paramListView instanceof SystemAndEmojiEmoticonInfo))
        {
          paramListView = (SystemAndEmojiEmoticonInfo)paramListView;
          if ((paramListView.type != 3) && (paramListView.code != -1))
          {
            paramListView = paramListView.getDrawable(false);
            if ((paramListView instanceof URLDrawable))
            {
              paramListView = (URLDrawable)paramListView;
              if ((paramListView != null) && (paramListView.getStatus() != 1)) {
                paramListView.startDownload();
              }
            }
          }
        }
        i += 1;
      }
      j = k * 7 - 1;
      i = j;
      while ((i >= 0) && (i > j - 35) && (i < paramList.size()))
      {
        paramListView = (EmotionPanelData)paramList.get(i);
        if ((paramListView instanceof SystemAndEmojiEmoticonInfo))
        {
          paramListView = (SystemAndEmojiEmoticonInfo)paramListView;
          if ((paramListView.type != 3) && (paramListView.code != -1))
          {
            paramListView = paramListView.getDrawable(getContext(), this.density);
            if ((paramListView instanceof URLDrawable))
            {
              paramListView = (URLDrawable)paramListView;
              if ((paramListView != null) && (paramListView.getStatus() != 1)) {
                paramListView.startDownload();
              }
            }
          }
        }
        i -= 1;
      }
    }
  }
  
  private void setShowDescribeInPreview(boolean paramBoolean)
  {
    this.mShowDescribeInPreview = paramBoolean;
  }
  
  private void updateSystemSmallEmojiAlpha(AbsListView paramAbsListView)
  {
    if (paramAbsListView != null)
    {
      int m = paramAbsListView.getChildCount();
      int i = 0;
      while (i < m)
      {
        Object localObject = paramAbsListView.getChildAt(i);
        if ((localObject instanceof ViewGroup))
        {
          localObject = (ViewGroup)localObject;
          int k = ((ViewGroup)localObject).getChildCount() - 1;
          int j = k;
          while (j >= 0)
          {
            View localView = ((ViewGroup)localObject).getChildAt(k);
            localView.getLocationOnScreen(this.point);
            this.point[0] = localView.getLeft();
            if ((this.minAlphaLeft > 0) && (this.point[0] + localView.getWidth() * 2.0F / 3.0F > this.minAlphaLeft) && (this.minAlphaTop > 0) && (this.point[1] + localView.getWidth() - this.spacing > this.minAlphaTop)) {
              updateViewAlpha(localView);
            } else {
              localView.setAlpha(1.0F);
            }
            j -= 1;
          }
        }
        i += 1;
      }
    }
  }
  
  private void updateViewAlpha(View paramView)
  {
    if ((paramView instanceof URLImageView))
    {
      int i = this.point[1];
      int j = paramView.getWidth();
      int k = this.spacing;
      int m = this.minAlphaTop;
      float f1 = paramView.getWidth() / 2.0F;
      float f2 = i + j - k - m;
      if (f2 < f1)
      {
        paramView.setAlpha((f1 - f2) * 1.0F / f1);
        return;
      }
      paramView.setAlpha(0.0F);
      return;
    }
    paramView.setAlpha(1.0F);
  }
  
  private void updateViewAlpha(AbsListView paramAbsListView)
  {
    if (isShowDeleteButton())
    {
      int[] arrayOfInt = new int[2];
      this.mDeleteButton.getLocationOnScreen(arrayOfInt);
      this.minAlphaLeft = this.mDeleteButton.getLeft();
      this.minAlphaTop = arrayOfInt[1];
      updateSystemSmallEmojiAlpha(paramAbsListView);
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    ISystemAndEmojiPanelService.DispatchKeyEventListener localDispatchKeyEventListener = this.mDispatchKeyEventListener;
    if ((localDispatchKeyEventListener != null) && (localDispatchKeyEventListener.a(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected int getLayoutId()
  {
    return 2131629361;
  }
  
  public View getView()
  {
    return this;
  }
  
  public void init(IEmoticonMainPanelApp paramIEmoticonMainPanelApp)
  {
    setBackgroundColor(getResources().getColor(2131168260));
    this.density = getResources().getDisplayMetrics().density;
    this.spacing = ViewUtils.dip2px(5.0F);
    this.mPanelInfo = new EmotionPanelInfo(7, this.rowCount, null);
    this.mDeleteButton = ((ImageButton)findViewById(2131431715));
    if (this.mInputEdit != null)
    {
      this.mDeleteButton.setVisibility(0);
      Editable localEditable = this.mInputEdit.getText();
      this.mDeleteButton.setEnabled(TextUtils.isEmpty(localEditable) ^ true);
    }
    this.mDeleteButton.setOnClickListener(this);
    this.mEmotionPanelListView = ((EmotionPanelListView)findViewById(2131432477));
    this.mEmotionPanelListView.setDivider(null);
    this.mEmotionPanelListView.setEdgeEffectEnabled(false);
    this.mEmotionPanelListView.setSelector(2130852744);
    int i = getColumnNum();
    this.mSystemAndEmojiAdapter = new SystemAndEmojiAdapter(paramIEmoticonMainPanelApp, null, getContext(), i, 1, this.mPanelInfo.type, this.mCallback, 0);
    this.mSystemAndEmojiAdapter.setLastItemAddPaddingBottom(getLastItemAddPaddingBottom());
    this.mSystemAndEmojiAdapter.setShowDescribeInPreview(this.mShowDescribeInPreview);
    paramIEmoticonMainPanelApp = this.mSystemAndEmojiAdapter;
    paramIEmoticonMainPanelApp.widthPixels = this.mainPanelWidth;
    paramIEmoticonMainPanelApp.curPanelInfo = this.mPanelInfo;
    paramIEmoticonMainPanelApp.setCurrentListView(this.mEmotionPanelListView);
    this.mEmotionPanelListView.setAdapter(this.mSystemAndEmojiAdapter);
    asyncLoadData(i);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    EditText localEditText = this.mInputEdit;
    if (localEditText != null) {
      localEditText.addTextChangedListener(this.textWatcher);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131431715)
    {
      EmoticonCallback localEmoticonCallback = this.mCallback;
      if (localEmoticonCallback != null) {
        localEmoticonCallback.delete();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy() {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    EditText localEditText = this.mInputEdit;
    if (localEditText != null) {
      localEditText.removeTextChangedListener(this.textWatcher);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    for (;;)
    {
      int i;
      try
      {
        i = paramMotionEvent.getAction() & 0xFF;
        if (i != 0) {
          break label56;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      catch (Exception localException)
      {
        QLog.e("EmoticonUniversalPanel", 1, "onInterceptTouchEvent failed", localException);
      }
      getParent().requestDisallowInterceptTouchEvent(false);
      label56:
      do
      {
        return super.onInterceptTouchEvent(paramMotionEvent);
        if (i == 1) {
          break;
        }
      } while (i != 3);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredWidth();
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    paramInt2 = this.mainPanelWidth;
    if (paramInt1 != paramInt2)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onMeasure: oldWidth=");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(" newWidth=");
        localStringBuilder.append(paramInt1);
        QLog.d("EmoticonUniversalPanel", 2, localStringBuilder.toString());
      }
      EmotionPanelViewPool.getInstance().destory();
      EmotionPanelViewPool.widthPixels = paramInt1;
      boolean bool;
      if (paramInt1 / localDisplayMetrics.widthPixels < 0.66F) {
        bool = true;
      } else {
        bool = false;
      }
      this.multiWindowMode = bool;
      this.mainPanelWidth = paramInt1;
      if ((this.mSystemAndEmojiAdapter != null) && (this.mDeleteButton != null)) {
        ThreadManagerV2.getUIHandlerV2().post(new SystemAndEmojiUniversalPanel.2(this));
      }
    }
  }
  
  public void setDispatchKeyEventListener(ISystemAndEmojiPanelService.DispatchKeyEventListener paramDispatchKeyEventListener)
  {
    this.mDispatchKeyEventListener = paramDispatchKeyEventListener;
  }
  
  public void setEmoticonCallback(EmoticonCallback paramEmoticonCallback)
  {
    this.mCallback = paramEmoticonCallback;
  }
  
  public void setFilterSysFaceBeyond255Enable(boolean paramBoolean)
  {
    this.mFilterSysFaceBeyond255Enable = paramBoolean;
  }
  
  public void setRowCount(int paramInt)
  {
    this.rowCount = paramInt;
  }
  
  public void setShowCommonUsedSystemEmoji(boolean paramBoolean)
  {
    this.showCommonUsedSystemEmoji = paramBoolean;
  }
  
  public void setShowDeleteButton(EditText paramEditText)
  {
    this.mInputEdit = paramEditText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel
 * JD-Core Version:    0.7.0.1
 */