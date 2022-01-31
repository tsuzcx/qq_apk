package com.tencent.mobileqq.emotionintegrate;

import android.text.TextUtils;
import baqn;
import bayu;
import bdhb;
import com.tencent.mobileqq.data.MessageForPic;
import java.net.URL;

class SearchEmoticonFragment$2
  implements Runnable
{
  SearchEmoticonFragment$2(SearchEmoticonFragment paramSearchEmoticonFragment, MessageForPic paramMessageForPic) {}
  
  public void run()
  {
    Object localObject = bayu.a(this.a, 1, null);
    if ((localObject != null) && (baqn.a(((URL)localObject).toString()) == null))
    {
      localObject = baqn.d(((URL)localObject).toString());
      if ((!TextUtils.isEmpty(this.a.path)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        bdhb.d(this.a.path, (String)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.SearchEmoticonFragment.2
 * JD-Core Version:    0.7.0.1
 */