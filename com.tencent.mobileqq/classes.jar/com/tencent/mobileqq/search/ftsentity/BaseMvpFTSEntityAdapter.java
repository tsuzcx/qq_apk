package com.tencent.mobileqq.search.ftsentity;

import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.search.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseMvpFTSEntityAdapter
  extends BaseMvpFaceAdapter
{
  FTSEntitySearchDetailActivity jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity;
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private List jdField_b_of_type_JavaUtilList;
  private int c;
  private int d;
  
  public BaseMvpFTSEntityAdapter(ListView paramListView, FaceDecoder paramFaceDecoder, List paramList, String paramString, FTSEntitySearchDetailActivity paramFTSEntitySearchDetailActivity)
  {
    super(paramListView, paramFaceDecoder);
    this.jdField_b_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity = paramFTSEntitySearchDetailActivity;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void b()
  {
    if ((this.d - this.c == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_Int == 0)) {
      a();
    }
  }
  
  public void a()
  {
    ArrayList localArrayList = SQLiteFTSUtils.a(this.jdField_a_of_type_JavaLangString);
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i;
    if (j + 50 < this.jdField_b_of_type_JavaUtilList.size()) {
      i = j + 50;
    }
    while (j < i)
    {
      FTSEntitySearchResultDetailModel localFTSEntitySearchResultDetailModel = FTSEntitySearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.app, this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, localArrayList, (FTSEntity)this.jdField_b_of_type_JavaUtilList.get(j));
      if (localFTSEntitySearchResultDetailModel != null) {
        this.jdField_a_of_type_JavaUtilList.add(localFTSEntitySearchResultDetailModel);
      }
      j += 1;
      continue;
      i = this.jdField_b_of_type_JavaUtilList.size();
    }
    a(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    super.a(paramAbsListView, paramInt);
    b();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.d = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.BaseMvpFTSEntityAdapter
 * JD-Core Version:    0.7.0.1
 */