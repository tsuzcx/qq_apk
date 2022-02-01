import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class nxx
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static nxx jdField_a_of_type_Nxx;
  private URLDrawable.DownloadListener jdField_a_of_type_ComTencentImageURLDrawable$DownloadListener = new nxy(this);
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ArrayList<String> b = new ArrayList();
  
  public static nxx a()
  {
    if (jdField_a_of_type_Nxx == null) {
      jdField_a_of_type_Nxx = new nxx();
    }
    return jdField_a_of_type_Nxx;
  }
  
  private void a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable == null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        String str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawableHelper.getDrawable(str);
        this.jdField_a_of_type_ComTencentImageURLDrawable.setDownloadListener(this.jdField_a_of_type_ComTencentImageURLDrawable$DownloadListener);
        this.jdField_a_of_type_ComTencentImageURLDrawable.downloadImediatly();
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementCoverPreloadManager", 2, "startImageDownload url:" + str);
        }
      }
      return;
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (paramArrayList == null) || (paramArrayList.size() <= 0)) {
        break label118;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        if ((!TextUtils.isEmpty(str)) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(str)))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(str);
          if (QLog.isColorLevel()) {
            QLog.d("AdvertisementCoverPreloadManager", 2, "addImagesToPreload url:" + str);
          }
        }
      }
    }
    a();
    label118:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nxx
 * JD-Core Version:    0.7.0.1
 */