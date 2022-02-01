package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import com.tencent.image.ApngDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.Item;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class InformationFaceAdapter$InformationItemLayout$1
  implements INetEngineListener
{
  InformationFaceAdapter$InformationItemLayout$1(InformationFaceAdapter.InformationItemLayout paramInformationItemLayout, File paramFile, WeakReference paramWeakReference1, WeakReference paramWeakReference2, String paramString, boolean paramBoolean, InformationFaceAdapter.URLDrawableListener paramURLDrawableListener, WeakReference paramWeakReference3) {}
  
  public void onResp(NetResp paramNetResp)
  {
    String str = ((InfomationFacePackage.Item)paramNetResp.mReq.getUserData()).e;
    if (QLog.isColorLevel()) {
      QLog.d("InformationFaceAdapter", 2, "onResp ,url is :" + str + " http status:" + paramNetResp.mHttpCode);
    }
    bool2 = false;
    bool1 = bool2;
    if (paramNetResp.mHttpCode == 200)
    {
      bool1 = bool2;
      if (!this.jdField_a_of_type_JavaIoFile.exists()) {}
    }
    for (;;)
    {
      try
      {
        bool1 = ApngDrawable.isApngFile(this.jdField_a_of_type_JavaIoFile);
        if (!bool1) {
          continue;
        }
        bool1 = true;
      }
      catch (IOException paramNetResp)
      {
        paramNetResp.printStackTrace();
        bool1 = bool2;
        continue;
      }
      ThreadManager.getUIHandler().post(new InformationFaceAdapter.InformationItemLayout.1.1(this, bool1));
      return;
      this.jdField_a_of_type_JavaIoFile.delete();
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("InformationFaceAdapter", 2, "onResp ,valid apng file");
        bool1 = bool2;
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    int i = (int)(100L * paramLong1 / paramLong2);
    if (QLog.isColorLevel()) {
      QLog.d("InformationFaceAdapter", 2, "apng percent:" + i);
    }
    ThreadManager.getUIHandler().post(new InformationFaceAdapter.InformationItemLayout.1.2(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.InformationItemLayout.1
 * JD-Core Version:    0.7.0.1
 */