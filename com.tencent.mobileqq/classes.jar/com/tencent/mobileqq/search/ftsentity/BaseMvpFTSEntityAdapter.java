package com.tencent.mobileqq.search.ftsentity;

import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.search.base.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.search.base.view.IFaceView;
import com.tencent.mobileqq.search.model.IFaceModel;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseMvpFTSEntityAdapter<M extends IFaceModel, V extends IFaceView>
  extends BaseMvpFaceAdapter<M, V>
{
  FTSEntitySearchDetailActivity jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity;
  private String jdField_a_of_type_JavaLangString;
  private List<FTSEntitySearchResultDetailModel> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private List<FTSEntity> jdField_b_of_type_JavaUtilList;
  private int c;
  private int d = 0;
  
  public BaseMvpFTSEntityAdapter(ListView paramListView, IFaceDecoder paramIFaceDecoder, List<FTSEntity> paramList, String paramString, FTSEntitySearchDetailActivity paramFTSEntitySearchDetailActivity)
  {
    super(paramListView, paramIFaceDecoder);
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
    int i = j + 50;
    if (i >= this.jdField_b_of_type_JavaUtilList.size()) {
      i = this.jdField_b_of_type_JavaUtilList.size();
    }
    while (j < i)
    {
      FTSEntitySearchResultDetailModel localFTSEntitySearchResultDetailModel = FTSEntitySearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.app, this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, localArrayList, (FTSEntity)this.jdField_b_of_type_JavaUtilList.get(j));
      if (localFTSEntitySearchResultDetailModel != null) {
        this.jdField_a_of_type_JavaUtilList.add(localFTSEntitySearchResultDetailModel);
      }
      j += 1;
    }
    a(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.d = paramInt3;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.BaseMvpFTSEntityAdapter
 * JD-Core Version:    0.7.0.1
 */