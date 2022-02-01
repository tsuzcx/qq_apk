package com.tencent.mobileqq.search.ftsentity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import java.util.ArrayList;
import java.util.List;

public abstract class FTSEntitySearchResultModel
  extends ISearchResultPositionModel
{
  protected String a;
  protected String b;
  protected ArrayList<String> c;
  protected QQAppInterface d;
  protected CharSequence e;
  protected CharSequence f;
  protected CharSequence g;
  protected CharSequence h;
  public int i = -1;
  public int j = -1;
  public int k = -1;
  public int l = -1;
  protected List<? extends FTSEntity> m;
  
  public FTSEntitySearchResultModel(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ArrayList<String> paramArrayList, List<? extends FTSEntity> paramList)
  {
    this.d = paramQQAppInterface;
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramArrayList;
    this.m = paramList;
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String g()
  {
    return this.a;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public abstract CharSequence i();
  
  public abstract CharSequence j();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchResultModel
 * JD-Core Version:    0.7.0.1
 */