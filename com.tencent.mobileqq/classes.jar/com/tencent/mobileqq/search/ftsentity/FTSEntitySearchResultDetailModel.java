package com.tencent.mobileqq.search.ftsentity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.ArrayList;

public abstract class FTSEntitySearchResultDetailModel
  extends ISearchResultPositionModel
{
  public QQAppInterface a;
  public FTSEntity a;
  public CharSequence a;
  public String a;
  protected ArrayList a;
  public CharSequence b;
  public CharSequence c;
  private CharSequence d;
  
  public FTSEntitySearchResultDetailModel(QQAppInterface paramQQAppInterface, String paramString, ArrayList paramArrayList, FTSEntity paramFTSEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSEntity = paramFTSEntity;
  }
  
  public int a()
  {
    return 1;
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
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public abstract CharSequence e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchResultDetailModel
 * JD-Core Version:    0.7.0.1
 */