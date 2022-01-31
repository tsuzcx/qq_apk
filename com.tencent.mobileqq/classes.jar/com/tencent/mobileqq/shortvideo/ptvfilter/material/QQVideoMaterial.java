package com.tencent.mobileqq.shortvideo.ptvfilter.material;

import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleItem;
import com.tencent.mobileqq.shortvideo.ptvfilter.NonFitItem;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.VideoMaterialUtil.AR_MATERIAL_TYPE;
import java.util.ArrayList;
import java.util.List;

public class QQVideoMaterial
  extends VideoMaterial
{
  public int a;
  private DoodleItem a;
  public BuckleFaceItem a;
  public String a;
  public List a;
  public boolean a;
  public NonFitItem[] a;
  public int b;
  private List b;
  public boolean b;
  public int c;
  public boolean c = true;
  public boolean d = false;
  private boolean e = false;
  
  public QQVideoMaterial()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public DoodleItem a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleItem;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(DoodleItem paramDoodleItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleItem = paramDoodleItem;
  }
  
  public void a(List paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void a(NonFitItem[] paramArrayOfNonFitItem)
  {
    if ((paramArrayOfNonFitItem != null) && (paramArrayOfNonFitItem.length > 0)) {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoPtvfilterNonFitItem = paramArrayOfNonFitItem;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilList.size() > 0;
  }
  
  public NonFitItem[] a()
  {
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoPtvfilterNonFitItem;
  }
  
  public List b()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public boolean b()
  {
    return getArParticleType() == VideoMaterialUtil.AR_MATERIAL_TYPE.CLICKABLE.value;
  }
  
  public List c()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoPtvfilterNonFitItem != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoPtvfilterNonFitItem.length > 0)
      {
        localObject1 = new ArrayList();
        int i = 0;
        while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoPtvfilterNonFitItem.length)
        {
          ((List)localObject1).add(this.jdField_a_of_type_ArrayOfComTencentMobileqqShortvideoPtvfilterNonFitItem[i]);
          i += 1;
        }
      }
    }
    return localObject1;
  }
  
  public boolean c()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.material.QQVideoMaterial
 * JD-Core Version:    0.7.0.1
 */