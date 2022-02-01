package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class FastWebArticleInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FastWebArticleInfo> CREATOR = new FastWebArticleInfo.1();
  public List<ArticleTopicInfo> A;
  public int B = 0;
  public String C = "";
  public String D;
  public String E;
  public SparseArray<ModuleInfo> F = new SparseArray();
  public String G;
  public int H;
  public List<ArticleTopicInfo> I;
  public final List<String> J = new ArrayList();
  public boolean K;
  public String L;
  public int M;
  public boolean N;
  protected final Map<String, JSONObject> a = new HashMap();
  public String b;
  public long c;
  public long d;
  public long e;
  public int f;
  public long g = 0L;
  public boolean h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public int s;
  public String t;
  public String u;
  public String v;
  public boolean w;
  public String x;
  public long y;
  public boolean z;
  
  public JSONObject a(String paramString)
  {
    return (JSONObject)this.a.get(paramString);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.d = paramLong1;
    this.c = paramLong2;
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    this.a.put(paramString, paramJSONObject);
  }
  
  public void a(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.s & 0x2) != 0;
  }
  
  public boolean b()
  {
    return this.z;
  }
  
  public boolean c()
  {
    return (this.s & 0x1) == 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FastWebArticleInfo{articleContent='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", articleReadCnt=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", commentCnt=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", biuCnt=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", likeCnt=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", isLiked=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", commentJumpUrl='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", title='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", desc='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", accountName='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append(", publicTime='");
    localStringBuilder.append(this.m);
    localStringBuilder.append('\'');
    localStringBuilder.append(", accountIcon='");
    localStringBuilder.append(this.n);
    localStringBuilder.append('\'');
    localStringBuilder.append(", accountAuthor='");
    localStringBuilder.append(this.o);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shareWord='");
    localStringBuilder.append(this.p);
    localStringBuilder.append('\'');
    localStringBuilder.append(", rowKey='");
    localStringBuilder.append(this.q);
    localStringBuilder.append('\'');
    localStringBuilder.append(", articleContentUrl='");
    localStringBuilder.append(this.r);
    localStringBuilder.append('\'');
    localStringBuilder.append(", flag=");
    localStringBuilder.append(this.s);
    localStringBuilder.append(", tags='");
    localStringBuilder.append(this.t);
    localStringBuilder.append('\'');
    localStringBuilder.append(", unionSentimentEntity='");
    localStringBuilder.append(this.u);
    localStringBuilder.append('\'');
    localStringBuilder.append(", unioChann='");
    localStringBuilder.append(this.v);
    localStringBuilder.append('\'');
    localStringBuilder.append(", needUpdataDynamicData=");
    localStringBuilder.append(this.w);
    localStringBuilder.append(", articleId='");
    localStringBuilder.append(this.x);
    localStringBuilder.append('\'');
    localStringBuilder.append(", puin=");
    localStringBuilder.append(this.y);
    localStringBuilder.append(", isFavorite=");
    localStringBuilder.append(this.z);
    localStringBuilder.append(", mTopicInfo=");
    localStringBuilder.append(this.A);
    localStringBuilder.append(", mSourceIds=");
    localStringBuilder.append(this.J);
    localStringBuilder.append(", mDynamicJsonData=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mBusinessCashFlag=");
    localStringBuilder.append(this.B);
    localStringBuilder.append(", mBusinessCashInfo='");
    localStringBuilder.append(this.C);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mProteusJsonData='");
    localStringBuilder.append(this.D);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mArticleCoverUrl='");
    localStringBuilder.append(this.E);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mUpdateModuleInfos=");
    localStringBuilder.append(this.F);
    localStringBuilder.append(", articleUrl='");
    localStringBuilder.append(this.G);
    localStringBuilder.append('\'');
    localStringBuilder.append(", articleSource=");
    localStringBuilder.append(this.H);
    localStringBuilder.append(", useWebview=");
    localStringBuilder.append(this.K);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo
 * JD-Core Version:    0.7.0.1
 */