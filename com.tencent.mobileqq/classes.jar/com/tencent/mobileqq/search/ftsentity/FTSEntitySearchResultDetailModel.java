package com.tencent.mobileqq.search.ftsentity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.ArrayList;

public abstract class FTSEntitySearchResultDetailModel
  extends ISearchResultPositionModel
{
  protected QQAppInterface a;
  protected FTSEntity a;
  protected CharSequence a;
  protected String a;
  protected ArrayList<String> a;
  protected CharSequence b;
  protected CharSequence c;
  private CharSequence d;
  
  public FTSEntitySearchResultDetailModel(QQAppInterface paramQQAppInterface, String paramString, ArrayList<String> paramArrayList, FTSEntity paramFTSEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity = paramFTSEntity;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    if (this.d == null) {
      this.d = SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity.mContent, this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity.mProximityStart, this.jdField_a_of_type_JavaUtilArrayList);
    }
    return this.d;
  }
  
  public int c()
  {
    return 1;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public abstract CharSequence e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchResultDetailModel
 * JD-Core Version:    0.7.0.1
 */