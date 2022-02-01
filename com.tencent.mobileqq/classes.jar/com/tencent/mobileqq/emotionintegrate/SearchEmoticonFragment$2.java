package com.tencent.mobileqq.emotionintegrate;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import java.net.URL;

class SearchEmoticonFragment$2
  implements Runnable
{
  SearchEmoticonFragment$2(SearchEmoticonFragment paramSearchEmoticonFragment, MessageForPic paramMessageForPic) {}
  
  public void run()
  {
    Object localObject = URLDrawableHelper.getURL(this.a, 1, null);
    if ((localObject != null) && (AbsDownloader.getFile(((URL)localObject).toString()) == null))
    {
      localObject = AbsDownloader.getFilePath(((URL)localObject).toString());
      if ((!TextUtils.isEmpty(this.a.path)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        FileUtils.copyFile(this.a.path, (String)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.SearchEmoticonFragment.2
 * JD-Core Version:    0.7.0.1
 */