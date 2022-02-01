package com.tencent.widget.pull2refresh;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;

public class XLoadMoreLayout
  extends FrameLayout
  implements ILoadMoreLayout
{
  public static final int CAN_MORE = 2;
  public static final int HIDE = 0;
  public static final int LOADING = 1;
  public static final int LOAD_MORE_ERROR = 5;
  public static final int LOAD_MORE_PENDING = 3;
  public static final int NO_MORE_DATA = 4;
  protected String mCanMoreText;
  protected Context mContext;
  protected View mLoadLayout;
  protected String mLoadMoreError;
  protected String mLoadingText;
  protected String mNoMoreDataText;
  protected ProgressBar mProgressBar;
  protected int mState = -1;
  protected TextView mTextView;
  protected String mWillLoadMoreText;
  
  public XLoadMoreLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public XLoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public XLoadMoreLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private boolean checkStateSwitch(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return true;
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            if (paramInt1 != 4)
            {
              if ((paramInt1 == 5) && ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 3))) {
                return true;
              }
            }
            else if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 3)) {
              return true;
            }
          }
          else if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 4) || (paramInt2 == 5)) {
            return true;
          }
        }
        else if ((paramInt2 == 0) || (paramInt2 == 3) || (paramInt2 == 4) || (paramInt2 == 5)) {
          return true;
        }
      }
      else
      {
        if ((paramInt2 == 0) || (paramInt2 == 3) || (paramInt2 == 4)) {
          break label145;
        }
        if (paramInt2 == 5) {
          return true;
        }
      }
      return false;
    }
    label145:
    return true;
  }
  
  private void init()
  {
    initResources();
    initView();
  }
  
  private void initResources()
  {
    this.mWillLoadMoreText = HardCodeUtil.a(2131695286);
    this.mCanMoreText = HardCodeUtil.a(2131695282);
    this.mNoMoreDataText = HardCodeUtil.a(2131695285);
    this.mLoadingText = getResources().getString(2131695284);
    this.mLoadMoreError = HardCodeUtil.a(2131695283);
  }
  
  private void initView()
  {
    LayoutInflater.from(getContext()).inflate(2131559641, this, true);
    this.mLoadLayout = findViewById(2131373269);
    this.mProgressBar = ((ProgressBar)this.mLoadLayout.findViewById(2131373273));
    this.mTextView = ((TextView)this.mLoadLayout.findViewById(2131373274));
    updateState(0);
  }
  
  private boolean updateState(int paramInt)
  {
    if (!checkStateSwitch(this.mState, paramInt)) {
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
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return true;
              }
              this.mProgressBar.setVisibility(8);
              this.mTextView.setText(this.mLoadMoreError);
              this.mLoadLayout.setVisibility(0);
              return true;
            }
            this.mLoadLayout.setVisibility(8);
            return true;
          }
          this.mProgressBar.setVisibility(8);
          this.mTextView.setText(this.mWillLoadMoreText);
          this.mLoadLayout.setVisibility(0);
          return true;
        }
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mCanMoreText);
        this.mLoadLayout.setVisibility(0);
        return true;
      }
      this.mProgressBar.setVisibility(0);
      this.mTextView.setText(this.mLoadingText);
      this.mLoadLayout.setVisibility(0);
      return true;
    }
    this.mLoadLayout.setVisibility(8);
    return true;
  }
  
  public boolean checkState(int paramInt)
  {
    return checkStateSwitch(this.mState, paramInt);
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mLoadLayout.setOnClickListener(paramOnClickListener);
  }
  
  public boolean setState(int paramInt)
  {
    return updateState(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.XLoadMoreLayout
 * JD-Core Version:    0.7.0.1
 */