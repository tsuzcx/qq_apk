package com.tencent.mobileqq.kandian.biz.pts.data;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import org.json.JSONObject;

public class ProteusItemDataBuilder
{
  JSONObject a = new JSONObject();
  
  public ProteusItemDataBuilder A(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.S(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder B(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return this;
  }
  
  public ProteusItemDataBuilder C(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.a(this.a, paramAbsBaseArticleInfo);
    return this;
  }
  
  public ProteusItemDataBuilder D(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.U(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder E(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mChannelID == 0L)) {
      return this;
    }
    Util.a(this.a);
    return this;
  }
  
  public ProteusItemDataBuilder F(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.y(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder G(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.V(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder H(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.W(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder I(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.Y(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder J(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.Z(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder K(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.aa(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder L(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.X(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder M(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.C(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder N(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.E(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder O(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.Q(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder P(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.ag(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder Q(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.am(paramAbsBaseArticleInfo, this.a);
    Util.ah(paramAbsBaseArticleInfo, this.a);
    Util.ai(paramAbsBaseArticleInfo, this.a);
    Util.aj(paramAbsBaseArticleInfo, this.a);
    Util.ak(paramAbsBaseArticleInfo, this.a);
    Util.al(paramAbsBaseArticleInfo, this.a);
    Util.ao(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    J(paramAbsBaseArticleInfo);
    K(paramAbsBaseArticleInfo);
    return this;
  }
  
  public ProteusItemDataBuilder a(AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong)
  {
    Util.a(paramAbsBaseArticleInfo, this.a, Long.valueOf(paramLong));
    return this;
  }
  
  public ProteusItemDataBuilder a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    Util.c(paramAbsBaseArticleInfo, this.a, paramString);
    return this;
  }
  
  public ProteusItemDataBuilder a(String paramString)
  {
    this.a.put("style_ID", paramString);
    return this;
  }
  
  public ProteusItemDataBuilder a(String paramString, Object paramObject)
  {
    this.a.put(paramString, paramObject);
    return this;
  }
  
  public JSONObject a()
  {
    return this.a;
  }
  
  public ProteusItemDataBuilder b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.r(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder b(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    Util.b(paramAbsBaseArticleInfo, this.a, paramString);
    return this;
  }
  
  public ProteusItemDataBuilder c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.A(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder c(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    Util.d(paramAbsBaseArticleInfo, this.a, paramString);
    return this;
  }
  
  public ProteusItemDataBuilder d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.s(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder d(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    Util.e(paramAbsBaseArticleInfo, this.a, paramString);
    return this;
  }
  
  public ProteusItemDataBuilder e(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.t(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder f(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.u(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder g(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.v(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder h(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.w(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder i(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.T(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder j(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.b(paramAbsBaseArticleInfo, this.a, "id_dislike_button");
    return this;
  }
  
  public ProteusItemDataBuilder k(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.l(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder l(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.m(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder m(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.L(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder n(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.J(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder o(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.M(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder p(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.N(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder q(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.K(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder r(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.n(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder s(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.o(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder t(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.p(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder u(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.q(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder v(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.G(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder w(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.I(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder x(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.O(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder y(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.P(paramAbsBaseArticleInfo, this.a);
    return this;
  }
  
  public ProteusItemDataBuilder z(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.R(paramAbsBaseArticleInfo, this.a);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.data.ProteusItemDataBuilder
 * JD-Core Version:    0.7.0.1
 */