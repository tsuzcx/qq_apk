package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.qphone.base.util.QLog;

public class NewPolymericInfo$PackArticleInfo
  implements Cloneable
{
  public long a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public int h;
  public long i;
  public long j;
  public int k;
  public String l;
  public int m;
  public int n;
  public NewPolymericInfo.PackVideoInfo o;
  public NewPolymericInfo.PackTopicExtraInfo p;
  public NewPolymericInfo.PackQuestionAnswerExtraInfo q;
  public String r;
  public boolean s;
  public String t;
  public int u;
  public int v;
  public String w;
  public int x;
  public String y;
  
  public Object clone()
  {
    PackArticleInfo localPackArticleInfo1;
    try
    {
      localPackArticleInfo1 = (PackArticleInfo)super.clone();
      try
      {
        if (this.o != null) {
          localPackArticleInfo1.o = ((NewPolymericInfo.PackVideoInfo)this.o.clone());
        }
        if (this.p != null) {
          localPackArticleInfo1.p = ((NewPolymericInfo.PackTopicExtraInfo)this.p.clone());
        }
        PackArticleInfo localPackArticleInfo2 = localPackArticleInfo1;
        if (this.q == null) {
          return ???;
        }
        localPackArticleInfo1.q = ((NewPolymericInfo.PackQuestionAnswerExtraInfo)this.q.clone());
        return localPackArticleInfo1;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException1) {}
      localStringBuilder = new StringBuilder();
    }
    catch (CloneNotSupportedException localCloneNotSupportedException2)
    {
      localPackArticleInfo1 = null;
    }
    StringBuilder localStringBuilder;
    localStringBuilder.append("PackArticleInfo item clone failed. exception = ");
    localStringBuilder.append(localCloneNotSupportedException2);
    QLog.e("NewPolymericInfo", 2, localStringBuilder.toString());
    PackArticleInfo localPackArticleInfo3 = localPackArticleInfo1;
    return localPackArticleInfo3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PackArticleInfo = {\ncellStyleID = ");
    localStringBuilder.append(this.t);
    localStringBuilder.append("\narticleID = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\narticleTitle = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\narticleSummary = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\nfirstPagePicUrl = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\narticleContentUrl = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\nsubscribeID = ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\nsubscribeName = ");
    localStringBuilder.append(this.g);
    localStringBuilder.append("\nstrategyID = ");
    localStringBuilder.append(this.h);
    localStringBuilder.append("\nalgorithmID = ");
    localStringBuilder.append(this.i);
    localStringBuilder.append("\nfeedsID = ");
    localStringBuilder.append(this.j);
    localStringBuilder.append("\nfeedsType = ");
    localStringBuilder.append(this.k);
    localStringBuilder.append("\ninnerUniqID = ");
    localStringBuilder.append(this.l);
    localStringBuilder.append("\nisGallery = ");
    localStringBuilder.append(this.m);
    localStringBuilder.append("\ngalleryPicNum = ");
    localStringBuilder.append(this.n);
    localStringBuilder.append("\nvideoInfo = ");
    localStringBuilder.append(this.o);
    localStringBuilder.append("\nbuttonWording = ");
    localStringBuilder.append(this.r);
    localStringBuilder.append("\nisUgc = ");
    localStringBuilder.append(this.s);
    localStringBuilder.append("\nplayCount=");
    localStringBuilder.append(this.v);
    localStringBuilder.append("commentCount=");
    localStringBuilder.append(this.x);
    localStringBuilder.append("isGifCoverUrl = ");
    localStringBuilder.append(this.u);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo
 * JD-Core Version:    0.7.0.1
 */