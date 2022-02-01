package com.tencent.mobileqq.emoticonview;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.EmoticonPackage;

class PicEmoticonInfo$2
  implements QueryCallback<EmoticonPackage>
{
  PicEmoticonInfo$2(PicEmoticonInfo paramPicEmoticonInfo, String paramString) {}
  
  public void postQuery(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.isAPNG == 2)) {
      URLDrawable.removeMemoryCacheByUrl(this.val$key);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.PicEmoticonInfo.2
 * JD-Core Version:    0.7.0.1
 */