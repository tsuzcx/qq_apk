package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import bdla;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class EmoticonLinearLayout
  extends LinearLayout
{
  static final String LOG_TAG = "EmoticonLinearLayout";
  private static Rect tmp = new Rect();
  EmoticonCallback callback;
  Context context;
  float density;
  public int emoticonTextColor;
  EmoticonLinearLayout.EmoticonAdapter mAdapter;
  Runnable mDelete = new EmoticonLinearLayout.2(this);
  boolean mHasPerformedLongPress;
  private EmoticonLinearLayout.CheckForLongPress mPendingCheckForLongPress;
  private EmoticonInfo mPointInfo;
  View mPointView;
  private FrameLayout mPopupEmo;
  private ImageView mPopupEmoImage;
  private FrameLayout mWindowContent;
  EmoticonLinearLayout.DataObserver observer = new EmoticonLinearLayout.1(this);
  public int panelViewType = 6;
  private AudioPlayer player;
  private boolean showing;
  List<RelativeLayout> viewCache = new ArrayList();
  
  public EmoticonLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    this.emoticonTextColor = super.getResources().getColor(2131166537);
    setOrientation(1);
    this.density = paramContext.getResources().getDisplayMetrics().density;
    super.setClickable(true);
    super.setLongClickable(true);
  }
  
  private View findPointChild(float paramFloat1, float paramFloat2)
  {
    int i = super.getChildCount() - 1;
    while (i >= 0)
    {
      LinearLayout localLinearLayout = (LinearLayout)super.getChildAt(i);
      float f1 = super.getScrollX() + paramFloat1 - localLinearLayout.getLeft();
      float f2 = super.getScrollY() + paramFloat2 - localLinearLayout.getTop();
      if ((f1 >= 0.0F) && (f1 <= localLinearLayout.getWidth()) && (f2 >= 0.0F) && (f2 < localLinearLayout.getHeight()))
      {
        int j = localLinearLayout.getChildCount() - 1;
        while (j >= 0)
        {
          View localView = localLinearLayout.getChildAt(j);
          float f3 = localLinearLayout.getScrollX() + f1 - localView.getLeft();
          float f4 = localLinearLayout.getScrollY() + f2 - localView.getTop();
          if ((f3 >= 0.0F) && (f3 <= localView.getWidth()) && (f4 >= 0.0F) && (f4 < localView.getHeight())) {
            return localView;
          }
          j -= 1;
        }
      }
      i -= 1;
    }
    return null;
  }
  
  private boolean getChildRect(View paramView, Rect paramRect)
  {
    if (paramView == null) {
      return false;
    }
    paramView.getDrawingRect(paramRect);
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    paramRect.offset(paramView.getLeft() - localViewGroup.getScrollX(), paramView.getTop() - localViewGroup.getScrollY());
    paramView = (ViewGroup)localViewGroup.getParent();
    paramRect.offset(localViewGroup.getLeft() - paramView.getScrollX(), localViewGroup.getTop() - paramView.getScrollY());
    return true;
  }
  
  private void performClick(View paramView)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof EmoticonInfo)))
    {
      paramView = (EmoticonInfo)paramView.getTag();
      if (paramView != null)
      {
        super.sendAccessibilityEvent(1);
        super.playSoundEffect(0);
        this.callback.send(paramView);
      }
    }
  }
  
  public void clear()
  {
    this.viewCache.clear();
  }
  
  public EmoticonLinearLayout.EmoticonAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  public void hidePopupWindow()
  {
    if ((this.mPopupEmo != null) && (this.showing))
    {
      ((WindowManager)getContext().getSystemService("window")).removeViewImmediate(this.mWindowContent);
      if (this.player != null) {
        this.player.c();
      }
      if (this.callback != null) {
        this.callback.onHidePopup(this.mPointInfo);
      }
      this.showing = false;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      if ((!this.mHasPerformedLongPress) && (this.mPendingCheckForLongPress != null)) {
        removeCallbacks(this.mPendingCheckForLongPress);
      }
      if ((this.mPointView != null) && (!this.mHasPerformedLongPress)) {
        performClick(this.mPointView);
      }
      hidePopupWindow();
      this.mPointView = null;
      super.removeCallbacks(this.mDelete);
      continue;
      this.mHasPerformedLongPress = false;
      this.mPointView = findPointChild(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (this.mPointView != null)
      {
        if (this.mPendingCheckForLongPress == null) {
          this.mPendingCheckForLongPress = new EmoticonLinearLayout.CheckForLongPress(this);
        }
        this.mPendingCheckForLongPress.rememberWindowAttachCount();
        postDelayed(this.mPendingCheckForLongPress, ViewConfiguration.getLongPressTimeout());
        paramMotionEvent = (EmoticonInfo)this.mPointView.getTag();
        if ((paramMotionEvent != null) && (this.callback != null) && ("delete".equals(paramMotionEvent.action)))
        {
          this.callback.delete();
          continue;
          setPressed(false);
          if (this.mPendingCheckForLongPress != null) {
            removeCallbacks(this.mPendingCheckForLongPress);
          }
          removeCallbacks(this.mDelete);
          hidePopupWindow();
          this.mPointView = null;
          continue;
          if ((this.mHasPerformedLongPress) && ((!getChildRect(this.mPointView, tmp)) || (!tmp.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
          {
            this.mPointView = findPointChild(paramMotionEvent.getX(), paramMotionEvent.getY());
            if ((this.mPointView != null) && (this.mPointView.getTag() != null))
            {
              paramMotionEvent = (EmoticonInfo)this.mPointView.getTag();
              if ((paramMotionEvent != null) && (!"delete".equals(paramMotionEvent.action)) && (!"add".equals(paramMotionEvent.action)) && (!"setting".equals(paramMotionEvent.action))) {
                showPopupEmo(this.mPointView, (EmoticonInfo)this.mPointView.getTag());
              }
            }
            else
            {
              hidePopupWindow();
            }
          }
          else if ((!this.mHasPerformedLongPress) && (this.mPointView != null) && ((!getChildRect(this.mPointView, tmp)) || (!tmp.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
          {
            this.mPointView = null;
          }
        }
      }
    }
  }
  
  public void setAdapter(EmoticonLinearLayout.EmoticonAdapter paramEmoticonAdapter)
  {
    this.mAdapter = paramEmoticonAdapter;
    this.mAdapter.setDataSetObserver(this.observer);
  }
  
  public void setCallBack(EmoticonCallback paramEmoticonCallback)
  {
    this.callback = paramEmoticonCallback;
  }
  
  public void setPanelViewType(int paramInt)
  {
    this.panelViewType = paramInt;
  }
  
  void showPopupEmo(View paramView, EmoticonInfo paramEmoticonInfo)
  {
    Drawable localDrawable = paramEmoticonInfo.getBigDrawable(this.context, this.density);
    if (localDrawable == null) {
      return;
    }
    paramView.getGlobalVisibleRect(tmp);
    int i = paramEmoticonInfo.type;
    if (this.mWindowContent == null)
    {
      this.mWindowContent = new FrameLayout(getContext());
      this.mPopupEmo = new FrameLayout(getContext());
      this.mPopupEmoImage = new ImageView(getContext());
      this.mPopupEmoImage.setAdjustViewBounds(false);
      this.mPopupEmoImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.mWindowContent.addView(this.mPopupEmo);
      this.mPopupEmo.addView(this.mPopupEmoImage);
    }
    this.mPopupEmoImage.setImageDrawable(localDrawable);
    float f = getContext().getResources().getDisplayMetrics().density;
    int k = (int)(5.0F * f);
    paramView = (FrameLayout.LayoutParams)this.mPopupEmoImage.getLayoutParams();
    int j;
    if ((i == 1) || (i == 2) || (i == 7) || (i == 10))
    {
      j = (int)(64.0F * f);
      i = (int)(71.0F * f);
      this.mPopupEmo.setBackgroundResource(2130838055);
      this.mPopupEmo.setPadding(k, k, k, k);
      paramView.width = ((int)(28.0F * f));
      paramView.height = ((int)(28.0F * f));
      paramView.bottomMargin = ((int)(6.0F * f));
      paramView.gravity = 17;
      label271:
      paramView = (FrameLayout.LayoutParams)this.mPopupEmo.getLayoutParams();
      paramView.gravity = 51;
      paramView.leftMargin = (tmp.left - (j - tmp.width()) / 2);
      paramView.topMargin = (tmp.top - i - (int)(15.0F * f));
      paramView.width = j;
      paramView.height = i;
      if (!this.showing) {
        break label685;
      }
      this.mPopupEmo.requestLayout();
    }
    for (;;)
    {
      paramView = this.mPointInfo;
      this.mPointInfo = paramEmoticonInfo;
      if ((paramView != null) && (paramView.type == 6) && ((paramView instanceof PicEmoticonInfo)) && (this.player != null)) {
        this.player.c();
      }
      if ((paramEmoticonInfo.type == 6) && ((paramEmoticonInfo instanceof PicEmoticonInfo)) && ((localDrawable instanceof URLDrawable)))
      {
        localObject = (PicEmoticonInfo)paramEmoticonInfo;
        if (((PicEmoticonInfo)localObject).isSound())
        {
          String str = EmoticonUtils.emoticonSoundPath.replace("[epId]", ((PicEmoticonInfo)localObject).emoticon.epId).replace("[eId]", ((PicEmoticonInfo)localObject).emoticon.eId);
          if (this.player == null) {
            this.player = new AudioPlayer(getContext(), null);
          }
          this.player.a(str);
          PicEmoticonInfo.startSoundDrawablePlay((URLDrawable)localDrawable);
        }
        if (2 == ((PicEmoticonInfo)localObject).emoticon.jobType) {
          bdla.b(null, "CliOper", "", "", "MbYulan", "MbChangan", 0, 0, ((PicEmoticonInfo)localObject).emoticon.epId, "", "", "");
        }
      }
      if (this.callback == null) {
        break;
      }
      this.callback.onShowPopup(paramView, paramEmoticonInfo, localDrawable);
      return;
      j = (int)(110.0F * f);
      i = (int)(110.0F * f);
      this.mPopupEmo.setBackgroundResource(2130838054);
      this.mPopupEmo.setPadding(k, k, k, k);
      paramView.bottomMargin = 0;
      paramView.width = ((int)(100.0F * f));
      paramView.height = ((int)(100.0F * f));
      bdla.b(null, "CliOper", "", "", "ep_mall", "ep_preview", 0, 0, "", "", "", "");
      break label271;
      label685:
      paramView = (WindowManager)getContext().getSystemService("window");
      i = 24;
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        i = 67108888;
      }
      Object localObject = new WindowManager.LayoutParams(-1, -1, 2, i, -3);
      paramView.addView(this.mWindowContent, (ViewGroup.LayoutParams)localObject);
      this.showing = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonLinearLayout
 * JD-Core Version:    0.7.0.1
 */