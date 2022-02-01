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
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.List;

public class SystemAndEmojiUniversalPanel
  extends RelativeLayout
  implements View.OnClickListener
{
  private static final int PRELOAD_LINE_NUM = 5;
  private static final String TAG = "EmoticonUniversalPanel";
  private float density;
  private EmoticonCallback mCallback;
  private ImageButton mDeleteButton;
  private SystemAndEmojiUniversalPanel.DispatchKeyEventListener mDispatchKeyEventListener;
  private EmotionPanelListView mEmotionPanelListView;
  private boolean mFilterSysFaceBeyond255Enable = false;
  private EditText mInputEdit;
  private EmotionPanelInfo mPanelInfo;
  private SystemAndEmojiAdapter mSystemAndEmojiAdapter;
  private int mainPanelWidth;
  private int minAlphaLeft;
  private int minAlphaTop;
  private boolean multiWindowMode;
  private int[] point = new int[2];
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
        QLog.d("EmoticonUniversalPanel", 2, "multiWindowMode: " + this.mPanelInfo.columnNum + "->" + j);
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
    return (this.mDeleteButton != null) && (this.mDeleteButton.getVisibility() == 0);
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
  
  private void updateSystemSmallEmojiAlpha(AbsListView paramAbsListView)
  {
    if (paramAbsListView != null)
    {
      int k = paramAbsListView.getChildCount();
      int i = 0;
      while (i < k)
      {
        View localView1 = paramAbsListView.getChildAt(i);
        if ((localView1 instanceof ViewGroup))
        {
          int m = ((ViewGroup)localView1).getChildCount();
          int j = m - 1;
          if (j >= 0)
          {
            View localView2 = ((ViewGroup)localView1).getChildAt(m - 1);
            localView2.getLocationOnScreen(this.point);
            this.point[0] = localView2.getLeft();
            if ((this.minAlphaLeft > 0) && (this.point[0] + localView2.getWidth() * 2.0F / 3.0F > this.minAlphaLeft) && (this.minAlphaTop > 0) && (this.point[1] + localView2.getWidth() - this.spacing > this.minAlphaTop)) {
              updateViewAlpha(localView2);
            }
            for (;;)
            {
              j -= 1;
              break;
              localView2.setAlpha(1.0F);
            }
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
      int i = this.point[1] + paramView.getWidth() - this.spacing - this.minAlphaTop;
      float f = paramView.getWidth() / 2.0F;
      if (i < f)
      {
        paramView.setAlpha((f - i) * 1.0F / f);
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
    if ((this.mDispatchKeyEventListener != null) && (this.mDispatchKeyEventListener.dispatchKeyEvent(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected int getLayoutId()
  {
    return 2131563076;
  }
  
  public void init(IEmoticonMainPanelApp paramIEmoticonMainPanelApp)
  {
    setBackgroundColor(getResources().getColor(2131167231));
    this.density = getResources().getDisplayMetrics().density;
    this.spacing = ViewUtils.a(5.0F);
    this.mPanelInfo = new EmotionPanelInfo(7, 7, null);
    this.mDeleteButton = ((ImageButton)findViewById(2131365656));
    ImageButton localImageButton;
    if (this.mInputEdit != null)
    {
      this.mDeleteButton.setVisibility(0);
      Editable localEditable = this.mInputEdit.getText();
      localImageButton = this.mDeleteButton;
      if (TextUtils.isEmpty(localEditable)) {
        break label258;
      }
    }
    label258:
    for (boolean bool = true;; bool = false)
    {
      localImageButton.setEnabled(bool);
      this.mDeleteButton.setOnClickListener(this);
      this.mEmotionPanelListView = ((EmotionPanelListView)findViewById(2131366301));
      this.mEmotionPanelListView.setDivider(null);
      this.mEmotionPanelListView.setEdgeEffectEnabled(false);
      this.mEmotionPanelListView.setSelector(2130850952);
      int i = getColumnNum();
      this.mSystemAndEmojiAdapter = new SystemAndEmojiAdapter(paramIEmoticonMainPanelApp, getContext(), i, 1, this.mPanelInfo.type, this.mCallback, 0);
      this.mSystemAndEmojiAdapter.setLastItemAddPaddingBottom(getLastItemAddPaddingBottom());
      this.mSystemAndEmojiAdapter.widthPixels = this.mainPanelWidth;
      this.mSystemAndEmojiAdapter.curPanelInfo = this.mPanelInfo;
      this.mSystemAndEmojiAdapter.setCurrentListView(this.mEmotionPanelListView);
      this.mEmotionPanelListView.setAdapter(this.mSystemAndEmojiAdapter);
      asyncLoadData(i);
      return;
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mInputEdit != null) {
      this.mInputEdit.addTextChangedListener(this.textWatcher);
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131365656) && (this.mCallback != null)) {
      this.mCallback.delete();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestory() {}
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mInputEdit != null) {
      this.mInputEdit.removeTextChangedListener(this.textWatcher);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    for (;;)
    {
      try
      {
        i = paramMotionEvent.getAction() & 0xFF;
        if (i != 0) {
          continue;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      catch (Exception localException)
      {
        int i;
        QLog.e("EmoticonUniversalPanel", 1, "onInterceptTouchEvent failed", localException);
        continue;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredWidth();
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    paramInt2 = this.mainPanelWidth;
    if (paramInt1 != paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonUniversalPanel", 2, "onMeasure: oldWidth=" + paramInt2 + " newWidth=" + paramInt1);
      }
      EmotionPanelViewPool.getInstance().destory();
      EmotionPanelViewPool.widthPixels = paramInt1;
      if (paramInt1 / localDisplayMetrics.widthPixels >= 0.66F) {
        break label140;
      }
    }
    label140:
    for (boolean bool = true;; bool = false)
    {
      this.multiWindowMode = bool;
      this.mainPanelWidth = paramInt1;
      if ((this.mSystemAndEmojiAdapter != null) && (this.mDeleteButton != null)) {
        ThreadManagerV2.getUIHandlerV2().post(new SystemAndEmojiUniversalPanel.2(this));
      }
      return;
    }
  }
  
  public void setDispatchKeyEventListener(SystemAndEmojiUniversalPanel.DispatchKeyEventListener paramDispatchKeyEventListener)
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