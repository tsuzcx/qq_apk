package com.tencent.mobileqq.mini.common.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/common/ui/LoadLayout;", "Landroid/widget/FrameLayout;", "mContext", "Landroid/content/Context;", "mOnLoadMoreClickAction", "Ljava/lang/Runnable;", "(Landroid/content/Context;Ljava/lang/Runnable;)V", "mDivider", "Landroid/view/View;", "mLoadLayout", "Landroid/widget/LinearLayout;", "mLoadMoreText", "", "mLoadingMoreText", "mLoadingText", "mNoMoreDataText", "mProgressBar", "Landroid/widget/ProgressBar;", "mState", "", "mTextView", "Landroid/widget/TextView;", "bindEvents", "", "checkState", "", "state", "getState", "initResources", "initView", "setDividerVisible", "visible", "setLoadMoreText", "loadManualText", "setLoadingMoreText", "loadingText", "setLoadingText", "setNoMoreDataText", "noMoreDataText", "setState", "setVisible", "updateState", "Companion", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public final class LoadLayout
  extends FrameLayout
{
  public static final LoadLayout.Companion Companion = new LoadLayout.Companion(null);
  public static final int HIDE = 0;
  public static final int LOADING = 1;
  public static final int LOADING_MORE = 2;
  public static final int LOAD_MORE_PENDING = 3;
  public static final int NO_MORE_DATA = 4;
  private final Context mContext;
  private View mDivider;
  private LinearLayout mLoadLayout;
  private String mLoadMoreText;
  private String mLoadingMoreText;
  private String mLoadingText;
  private String mNoMoreDataText;
  private final Runnable mOnLoadMoreClickAction;
  private ProgressBar mProgressBar;
  private int mState;
  private TextView mTextView;
  
  public LoadLayout(@NotNull Context paramContext, @Nullable Runnable paramRunnable)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mOnLoadMoreClickAction = paramRunnable;
    this.mState = -1;
    initResources();
    initView();
    bindEvents();
  }
  
  private final void bindEvents()
  {
    LinearLayout localLinearLayout = this.mLoadLayout;
    if (localLinearLayout == null) {
      Intrinsics.throwNpe();
    }
    localLinearLayout.setOnClickListener((View.OnClickListener)new LoadLayout.bindEvents.1(this));
  }
  
  private final void initResources()
  {
    this.mLoadMoreText = getResources().getString(2030436354);
    this.mLoadingMoreText = getResources().getString(2030436357);
    this.mNoMoreDataText = getResources().getString(2030436355);
    this.mLoadingText = getResources().getString(2030436356);
  }
  
  @SuppressLint({"InflateParams"})
  private final void initView()
  {
    Object localObject = LayoutInflater.from(this.mContext).inflate(2030370819, null);
    if (localObject != null)
    {
      this.mLoadLayout = ((LinearLayout)localObject);
      localObject = this.mLoadLayout;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      this.mProgressBar = ((ProgressBar)((LinearLayout)localObject).findViewById(2030305319));
      localObject = this.mLoadLayout;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      this.mTextView = ((TextView)((LinearLayout)localObject).findViewById(2030305329));
      localObject = this.mLoadLayout;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      this.mDivider = ((LinearLayout)localObject).findViewById(2030305297);
      localObject = new FrameLayout.LayoutParams(-1, -2);
      addView((View)this.mLoadLayout, (ViewGroup.LayoutParams)localObject);
      updateState(0);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
  }
  
  private final boolean updateState(int paramInt)
  {
    if (!Companion.checkStateSwitch(this.mState, paramInt)) {
      return false;
    }
    this.mState = paramInt;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return true;
            }
            localObject = this.mProgressBar;
            if (localObject == null) {
              Intrinsics.throwNpe();
            }
            ((ProgressBar)localObject).setVisibility(8);
            localObject = this.mTextView;
            if (localObject == null) {
              Intrinsics.throwNpe();
            }
            ((TextView)localObject).setText((CharSequence)this.mNoMoreDataText);
            localObject = this.mLoadLayout;
            if (localObject == null) {
              Intrinsics.throwNpe();
            }
            ((LinearLayout)localObject).setVisibility(0);
            return true;
          }
          localObject = this.mProgressBar;
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          ((ProgressBar)localObject).setVisibility(8);
          localObject = this.mTextView;
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          ((TextView)localObject).setText((CharSequence)this.mLoadMoreText);
          localObject = this.mLoadLayout;
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          ((LinearLayout)localObject).setVisibility(0);
          return true;
        }
        localObject = this.mProgressBar;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        ((ProgressBar)localObject).setVisibility(0);
        localObject = this.mTextView;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        ((TextView)localObject).setText((CharSequence)this.mLoadingMoreText);
        localObject = this.mLoadLayout;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        ((LinearLayout)localObject).setVisibility(0);
        return true;
      }
      localObject = this.mProgressBar;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((ProgressBar)localObject).setVisibility(0);
      localObject = this.mTextView;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((TextView)localObject).setText((CharSequence)this.mLoadingText);
      localObject = this.mLoadLayout;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((LinearLayout)localObject).setVisibility(0);
      return true;
    }
    Object localObject = this.mLoadLayout;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((LinearLayout)localObject).setVisibility(8);
    return true;
  }
  
  public final boolean checkState(int paramInt)
  {
    return Companion.checkStateSwitch(this.mState, paramInt);
  }
  
  public final int getState()
  {
    return this.mState;
  }
  
  public final void setDividerVisible(boolean paramBoolean)
  {
    View localView = this.mDivider;
    if (localView == null) {
      Intrinsics.throwNpe();
    }
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  public final void setLoadMoreText(@Nullable String paramString)
  {
    this.mLoadMoreText = paramString;
  }
  
  public final void setLoadingMoreText(@Nullable String paramString)
  {
    this.mLoadingMoreText = paramString;
  }
  
  public final void setLoadingText(@Nullable String paramString)
  {
    this.mLoadingText = paramString;
  }
  
  public final void setNoMoreDataText(@Nullable String paramString)
  {
    this.mNoMoreDataText = paramString;
  }
  
  public final boolean setState(int paramInt)
  {
    return updateState(paramInt);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = this.mLoadLayout;
    if (localLinearLayout == null) {
      Intrinsics.throwNpe();
    }
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localLinearLayout.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.common.ui.LoadLayout
 * JD-Core Version:    0.7.0.1
 */