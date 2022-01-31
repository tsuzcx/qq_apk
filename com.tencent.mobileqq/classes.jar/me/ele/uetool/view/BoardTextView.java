package me.ele.uetool.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;
import me.ele.uetool.UETool;
import me.ele.uetool.base.DimenUtil;

public class BoardTextView
  extends TextView
{
  private final String defaultInfo;
  private final int padding = DimenUtil.dip2px(3.0F);
  
  public BoardTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BoardTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BoardTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    try
    {
      paramContext = "UETool / " + UETool.getInstance().getTargetActivity().getClass().getName();
      this.defaultInfo = paramContext;
      initView();
      return;
    }
    catch (NullPointerException paramContext)
    {
      for (;;)
      {
        paramContext = "null";
      }
    }
  }
  
  private void initView()
  {
    setBackgroundColor(-1876716033);
    setPadding(this.padding, this.padding, this.padding, this.padding);
    setTextColor(-1);
    setTextSize(9.0F);
    setText(this.defaultInfo);
  }
  
  public void updateInfo(String paramString)
  {
    setText(paramString + "\n" + this.defaultInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.view.BoardTextView
 * JD-Core Version:    0.7.0.1
 */