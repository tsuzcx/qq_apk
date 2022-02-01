package dov.com.tencent.biz.qqstory.takevideo;

import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.paster.PasterDataManager;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePackage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.FacePanelBaseAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class EditVideoDoodle$DoodleFacePanelAdapter
  extends FacePanelBaseAdapter
{
  private final List<FacePackage> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final ConcurrentLinkedQueue<FacePackage> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private boolean jdField_a_of_type_Boolean = true;
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public FacePackage a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (FacePackage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public FacePackage a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
      a(((PasterDataManager)QIMManager.a(4)).a());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      FacePackage localFacePackage = (FacePackage)localIterator.next();
      if ((localFacePackage != null) && (TextUtils.equals(paramString, localFacePackage.jdField_a_of_type_JavaLangString))) {
        return localFacePackage;
      }
    }
    return null;
  }
  
  public void a(FacePackage paramFacePackage)
  {
    SLog.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackage " + paramFacePackage);
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramFacePackage);
    if (i >= 0)
    {
      this.jdField_a_of_type_JavaUtilList.set(i, paramFacePackage);
      a(i);
    }
  }
  
  public void a(Collection<FacePackage> paramCollection)
  {
    SLog.b("Q.qqstory.publish.edit.StoryDoodle", "DoodleFacePanelAdapter updateFacePackages size = " + paramCollection.size());
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        FacePackage localFacePackage = (FacePackage)paramCollection.next();
        if (localFacePackage != null)
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(localFacePackage);
          if (localFacePackage.jdField_a_of_type_Int == 0) {
            this.jdField_a_of_type_JavaUtilList.add(localFacePackage);
          }
        }
      }
    }
    finally {}
    a();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle.DoodleFacePanelAdapter
 * JD-Core Version:    0.7.0.1
 */