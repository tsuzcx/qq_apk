package cooperation.photoplus;

import android.text.TextUtils;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class PhotoPlusManager$UpdateTask
  implements Runnable
{
  private List<Sticker> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public PhotoPlusManager$UpdateTask(List<Sticker> paramList, boolean paramBoolean)
  {
    if (paramBoolean != null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(paramBoolean);
    }
    boolean bool;
    this.jdField_a_of_type_Boolean = bool;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      PhotoPlusManager.a(this.this$0, this.jdField_a_of_type_JavaUtilList);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPlusManager", 2, "[updateStickerResource] saved stickers = null");
      }
      return;
    }
    if (!FileUtils.hasSDCardAndWritable())
    {
      QLog.e("PhotoPlusManager", 1, "sdcard unavailable");
      return;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Object localObject1 = (Sticker)this.jdField_a_of_type_JavaUtilList.get(i);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[updateStickerResource] saved sticker:");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("PhotoPlusManager", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(PhotoPlusManager.a);
      ((StringBuilder)localObject2).append(((Sticker)localObject1).getZipFilePath());
      localObject2 = ((StringBuilder)localObject2).toString();
      if (!new File((String)localObject2).exists())
      {
        PhotoPlusManager.a(this.this$0, ((Sticker)localObject1).url, (String)localObject2, ((Sticker)localObject1).md5);
      }
      else
      {
        Object localObject3 = ((Sticker)localObject1).getUnzippedDir();
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(PhotoPlusManager.a);
        ((StringBuilder)localObject4).append((String)localObject3);
        ((StringBuilder)localObject4).append(((Sticker)localObject1).getImageFileName());
        localObject4 = ((StringBuilder)localObject4).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(PhotoPlusManager.a);
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(((Sticker)localObject1).getThumbImageFileName());
        localObject3 = localStringBuilder.toString();
        localObject4 = new File((String)localObject4);
        localObject3 = new File((String)localObject3);
        if ((!((File)localObject4).exists()) || (!((File)localObject3).exists()))
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("[updateStickerResource] zip exist but resource not exist:");
            ((StringBuilder)localObject3).append(((Sticker)localObject1).getZipFilePath());
            QLog.e("PhotoPlusManager", 2, ((StringBuilder)localObject3).toString());
          }
          if (TextUtils.isEmpty(((Sticker)localObject1).md5))
          {
            this.this$0.a((String)localObject2);
          }
          else
          {
            localObject3 = PortalUtils.a((String)localObject2);
            if (((Sticker)localObject1).md5.equalsIgnoreCase((String)localObject3))
            {
              this.this$0.a((String)localObject2);
            }
            else
            {
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("[updateStickerResource] checkMd5 failed: ");
                ((StringBuilder)localObject1).append((String)localObject2);
                QLog.d("PhotoPlusManager", 2, ((StringBuilder)localObject1).toString());
              }
              FileUtils.deleteFile((String)localObject2);
            }
          }
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.photoplus.PhotoPlusManager.UpdateTask
 * JD-Core Version:    0.7.0.1
 */