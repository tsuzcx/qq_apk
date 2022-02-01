package com.tencent.mobileqq.profile.PersonalityLabel;

import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class PersonalityLabelGalleryActivity$4
  implements Runnable
{
  PersonalityLabelGalleryActivity$4(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList(9);
    int i = PersonalityLabelGalleryActivity.d(this.this$0).size() - 1;
    while (i >= 0)
    {
      Object localObject = (String)PersonalityLabelGalleryActivity.d(this.this$0).get(i);
      if (this.this$0.n)
      {
        this.this$0.runOnUiThread(new PersonalityLabelGalleryActivity.4.1(this));
        return;
      }
      localObject = new CompressInfo((String)localObject, 0);
      ((CompressInfo)localObject).o = 0;
      ((ICompressOperator)QRoute.api(ICompressOperator.class)).startThumbnail((CompressInfo)localObject);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("personality_label uploadPhoto(), thumb_path = ");
        localStringBuilder.append(((CompressInfo)localObject).l);
        QLog.i("PersonalityLabelGalleryActivity", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(((CompressInfo)localObject).l))
      {
        localArrayList.add(localObject);
        localObject = new File(((CompressInfo)localObject).l);
        try
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("file:///");
          localStringBuilder.append(((File)localObject).getAbsolutePath());
          localObject = new URL(localStringBuilder.toString());
          int j = (int)(PersonalityLabelGalleryActivity.f(this.this$0) * 120.0F);
          URLDrawable.getDrawable((URL)localObject, j, j, this.this$0.d, this.this$0.d).startDownload();
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localMalformedURLException.printStackTrace();
        }
      }
      else
      {
        this.this$0.runOnUiThread(new PersonalityLabelGalleryActivity.4.2(this, i));
      }
      i -= 1;
    }
    if (localArrayList.size() > 0) {
      this.this$0.q.a(localArrayList, PersonalityLabelGalleryActivity.g(this.this$0));
    }
    this.this$0.runOnUiThread(new PersonalityLabelGalleryActivity.4.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.4
 * JD-Core Version:    0.7.0.1
 */