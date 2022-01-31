package me.ele.uetool.base.item;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View.OnClickListener;

public class TextItem
  extends TitleItem
{
  private String detail;
  private boolean enableCopy;
  private View.OnClickListener onClickListener;
  
  public TextItem(String paramString1, String paramString2)
  {
    super(paramString1);
    this.detail = paramString2;
  }
  
  public TextItem(String paramString1, String paramString2, View.OnClickListener paramOnClickListener)
  {
    super(paramString1);
    this.detail = paramString2;
    this.onClickListener = paramOnClickListener;
  }
  
  public TextItem(String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramString1);
    this.detail = paramString2;
    this.enableCopy = paramBoolean;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof TextItem)) {
      return (this.detail.equals(((TextItem)paramObject).detail)) && (getName().equals(((TextItem)paramObject).getName()));
    }
    return false;
  }
  
  public String getDetail()
  {
    return this.detail;
  }
  
  @Nullable
  public View.OnClickListener getOnClickListener()
  {
    return this.onClickListener;
  }
  
  public int hashCode()
  {
    return this.detail.hashCode() | getName().hashCode();
  }
  
  public boolean isEnableCopy()
  {
    return this.enableCopy;
  }
  
  public boolean isValid()
  {
    return !TextUtils.isEmpty(this.detail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.base.item.TextItem
 * JD-Core Version:    0.7.0.1
 */