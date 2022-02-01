package com.tencent.mobileqq.search.ftsentity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.ArrayList;

public abstract class FTSEntitySearchResultDetailModel
  extends ISearchResultPositionModel
{
  protected FTSEntity a;
  protected String b;
  protected ArrayList<String> c;
  protected CharSequence d;
  protected QQAppInterface e;
  protected CharSequence f;
  protected CharSequence g;
  private CharSequence h;
  
  public FTSEntitySearchResultDetailModel(QQAppInterface paramQQAppInterface, String paramString, ArrayList<String> paramArrayList, FTSEntity paramFTSEntity)
  {
    this.e = paramQQAppInterface;
    this.b = paramString;
    this.c = paramArrayList;
    this.a = paramFTSEntity;
  }
  
  public int b()
  {
    return 1;
  }
  
  public CharSequence e()
  {
    if (this.h == null) {
      this.h = SearchUtils.a(this.a.mContent, this.a.mProximityStart, this.c);
    }
    return this.h;
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String g()
  {
    return this.b;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public abstract CharSequence i();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchResultDetailModel
 * JD-Core Version:    0.7.0.1
 */