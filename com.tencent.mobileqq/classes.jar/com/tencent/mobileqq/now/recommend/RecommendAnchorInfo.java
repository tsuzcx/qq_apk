package com.tencent.mobileqq.now.recommend;

import com.tencent.mobileqq.nearby.now.model.MedalItem;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.MedalInfo;
import com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RichTitleElement;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

public class RecommendAnchorInfo
{
  public String A;
  public boolean B;
  private long C = -1L;
  private String D = null;
  private List<String> E = null;
  public String a;
  public int b;
  public int c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public int i;
  public boolean j = true;
  public int k = 0;
  public String l;
  public List<NowQQLiveHomepageProto.RichTitleElement> m;
  public MedalItem n;
  public String o;
  public String p;
  public String q;
  public long r;
  public int s = -16711936;
  public int t = -16711936;
  public String u;
  public String v = "NOW达人";
  public int w;
  public String x;
  public String y;
  public boolean z = false;
  
  public String a()
  {
    if (this.D == null)
    {
      Object localObject = this.m;
      String str = "";
      if ((localObject != null) && (((List)localObject).size() != 0))
      {
        int i1 = 0;
        int i2 = this.m.size();
        while (i1 < i2)
        {
          localObject = (NowQQLiveHomepageProto.RichTitleElement)this.m.get(i1);
          if (((NowQQLiveHomepageProto.RichTitleElement)localObject).uint32_type.get() != 2) {
            str = ((NowQQLiveHomepageProto.RichTitleElement)localObject).string_text.get();
          }
          i1 += 1;
        }
        this.D = str;
      }
      else
      {
        this.D = "";
      }
    }
    return this.D;
  }
  
  public void a(List<NowQQLiveHomepageProto.MedalInfo> paramList)
  {
    paramList = (NowQQLiveHomepageProto.MedalInfo)paramList.get(0);
    if (paramList.medal_type.get() != 3)
    {
      if (this.n == null) {
        this.n = new MedalItem();
      }
      this.n.a = paramList.medal_id.get();
      this.n.b = paramList.medal_version.get();
      this.n.f = paramList.medal_type.get();
      if (paramList.medal_name.has()) {
        this.n.c = paramList.medal_name.get().toStringUtf8();
      }
      if (paramList.medal_bg.has()) {
        this.n.l = paramList.medal_bg.get();
      }
      if (paramList.medal_frame.has()) {
        this.n.m = paramList.medal_frame.get();
      }
      if (paramList.medal_level.has()) {
        this.n.n = paramList.medal_level.get();
      }
    }
  }
  
  public String b()
  {
    if ((a() != null) && (this.D.length() > 0)) {
      return this.D;
    }
    return this.p;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.recommend.RecommendAnchorInfo
 * JD-Core Version:    0.7.0.1
 */