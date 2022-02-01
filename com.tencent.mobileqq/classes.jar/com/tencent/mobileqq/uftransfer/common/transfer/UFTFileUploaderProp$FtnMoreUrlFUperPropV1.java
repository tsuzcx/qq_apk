package com.tencent.mobileqq.uftransfer.common.transfer;

import android.text.TextUtils;
import java.util.List;

public class UFTFileUploaderProp$FtnMoreUrlFUperPropV1
  extends UFTFileUploaderProp.FtnFUperProp
{
  protected List<String> i;
  protected String j;
  protected boolean k;
  protected String l;
  
  public void a(List<String> paramList)
  {
    this.i = paramList;
  }
  
  public boolean a()
  {
    if (!super.a()) {
      return false;
    }
    List localList = this.i;
    if ((localList != null) && (localList.size() != 0))
    {
      if (TextUtils.isEmpty(this.j))
      {
        this.d = "urlParams is empty";
        return false;
      }
      return true;
    }
    this.d = "lstUrl is empty";
    return false;
  }
  
  public void b(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void e(String paramString)
  {
    this.j = paramString;
  }
  
  public void f(String paramString)
  {
    this.l = paramString;
  }
  
  public List<String> j()
  {
    return this.i;
  }
  
  public String k()
  {
    return this.j;
  }
  
  public boolean l()
  {
    return this.k;
  }
  
  public String m()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.FtnMoreUrlFUperPropV1
 * JD-Core Version:    0.7.0.1
 */