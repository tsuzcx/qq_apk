package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.Builder;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyLauncher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;

class FastWebActivity$4
  implements IServiceInfo
{
  FastWebActivity$4(FastWebActivity paramFastWebActivity) {}
  
  public ColorNote getColorNote()
  {
    Object localObject = FastWebActivity.d(this.a);
    String str2 = "";
    if ((localObject != null) && (FastWebActivity.d(this.a).n != null)) {
      localObject = FastWebActivity.d(this.a).n;
    } else {
      localObject = "";
    }
    ColorNote.Builder localBuilder = new ColorNote.Builder().a(16908290);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ReadInJoyLauncher.b);
    String str1;
    if (this.a.g == null) {
      str1 = "";
    } else {
      str1 = this.a.g.innerUniqueID;
    }
    localStringBuilder.append(str1);
    localBuilder = localBuilder.a(localStringBuilder.toString());
    if (this.a.g == null) {
      str1 = "";
    } else {
      str1 = this.a.g.mTitle;
    }
    localBuilder = localBuilder.b(str1);
    if (this.a.g == null) {
      str1 = str2;
    } else {
      str1 = this.a.g.mSubscribeName;
    }
    return localBuilder.c(str1).d((String)localObject).a(FastWebActivity.e(this.a)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.4
 * JD-Core Version:    0.7.0.1
 */