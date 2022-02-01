package cooperation.vip.qqbanner.info;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import cooperation.qzone.util.QZLog;

public class VasADBannerConfigInfo$ResourceInfo
{
  public String a;
  public String b;
  public String c;
  
  public void a(boolean paramBoolean)
  {
    if (QZLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" qboss resources down response resUrl = ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" isSuccess = ");
      localStringBuilder.append(paramBoolean);
      QZLog.i("VasADBannerConfigInfo", 2, localStringBuilder.toString());
    }
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.c)) {
      return false;
    }
    return FileUtil.d(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.qqbanner.info.VasADBannerConfigInfo.ResourceInfo
 * JD-Core Version:    0.7.0.1
 */