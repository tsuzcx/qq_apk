package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.filter.LongLegParam;
import java.util.List;

public class LongLegFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER = "mee1164x1667592816x1869181801x1768431726x544237671x1634692198x537541492x2037539190x543649385x845374838x2019914784x1701999988x1919905603x1634625892x171664756x1768846624x1836216166x1835103008x1919249520x1763722290x1953853550x1734438217x2019906661x1701999988x537541426x1718185589x544043631x1634692198x813244532x1965034043x1868982638x1713401202x1952542572x1920234272x1752458085x1769234770x537541487x1718185589x544043631x544501353x2003789939x1802658125x1965034043x1868982638x1763732850x1965061230x1969644915x537541484x1684631414x1767992608x170469486x537557792x538976288x673212009x1717924725x1025535093x691019837x537557792x538976288x538976288x1180658791x1130848626x1919904879x1948269856x1970567269x1144153458x1886284072x1833530485x1415931745x1970567269x741500274x2019914784x1701999988x1919905603x1634625892x992568692x538976266x538976288x1701978144x1852994932x538970683x2099257376x538970634x1713381408x1952542572x1917810976x1852401513x1948269856x1970567269x1866687858x1768190575x1702125934x171669806x538976288x1869375008x2032170081x997680462x538970634x1763713056x2032672870x1734963791x1008758377x691042592x537557792x538976288x538976288x2003127929x2032155936x1734963791x171667049x538976288x1696628000x543519596x537528955x538976288x538976288x1634692198x544481396x1333338173x1768384882x539828334x171651193x538976288x538976288x1869375008x1948284001x540876850x808333608x2032151840x706750768x774973472x539697200x1701999731x1382577251x1869182049x537541417x538976288x538976288x1634692198x829694068x1948269856x539631666x993144368x538976266x538976288x1818632224x544498031x1025520248x808333600x2032151840x537541424x538976288x538976288x1634692198x813047924x824196384x171651118x538976288x538976288x1869375008x1981838433x540876849x540178472x813047853x808333871x691106858x673197856x757084788x791770144x691023410x538970683x538976288x1713381408x1952542572x1025532192x829827104x1981820192x790636848x993096736x538976266x538976288x1818632224x544498031x537541496x538976288x538976288x673212009x540811380x539570548x538970747x538976288x538976288x2015371296x1981824288x539631664x539697268x540356144x543236138x544481322x997466154x538976266x538976288x545071136x1702063205x537557792x538976288x538976288x538976288x540876920x540356144x1982341162x539697200x539570550x829693994x1981819680x539631665x757101608x691106848x538970683x538976288x2099257376x538976266x538976288x1316560928x1025537893x540047648x997728299x538970634x2099257376x538970634x1730158624x1917214572x1866688353x544370540x1702109245x1920300152x675557989x1970302569x1634552180x1700029799x1920300152x539767397x845374838x2019914792x1701999988x1919905603x1634625892x2016306548x1316560940x690583397x168430139x538976288x543582496x1869116200x1918979447x1027416171x539570464x538970747x538976288x1763713056x2032672870x1734963791x1042312809x540047648x774905901x540094512x2032150054x1734963791x1008758377x540047648x774905899x691089456x537557792x538976288x538976288x538976288x1180658791x1130848626x1919904879x1981824288x674521957x741355057x808333344x774905900x824192048x992555054x538976266x538976288x175972384x538976288x168459552x168459552x";
  public static final String VERTEX_SHADER = "mee200x1920234593x1953849961x1702240357x1881158755x1953067887x997093225x1952522250x1651077748x543519861x878929270x1886284064x1700033653x1920300152x1869562725x1852400754x996504673x1981811210x1769566817x1981835118x540173157x1954047348x1130721909x1685221231x1952542313x168442725x1768912416x1634541668x690515561x175841290x538976288x1600939808x1769172816x1852795252x1881160992x1953067887x997093225x538976266x1702109216x1920300152x1869562725x1852400754x543519841x1852383293x1416918384x1970567269x1866687858x1768190575x1702125934x997816366x175972362x";
  private float curStrength;
  private float curY0;
  private int currentFrame;
  private boolean hasSeenValidPoints;
  private boolean legLineStable;
  private float lineMax;
  private float lineMin;
  private long previousLostWaistTime;
  private long previousTimeForChangeToStable;
  private long previousTimeForChangeToUnstable;
  private float previousValidWaistLine;
  private float[] previousWaistLines;
  private float rangeMax;
  private long timesForChangeToStable;
  private long timesForChangeToUnstable;
  private long usePreviousIfWithin = 2000L;
  private final int waistLineFrames = 8;
  
  public LongLegFilter()
  {
    super(BaseFilter.nativeDecrypt("mee200x1920234593x1953849961x1702240357x1881158755x1953067887x997093225x1952522250x1651077748x543519861x878929270x1886284064x1700033653x1920300152x1869562725x1852400754x996504673x1981811210x1769566817x1981835118x540173157x1954047348x1130721909x1685221231x1952542313x168442725x1768912416x1634541668x690515561x175841290x538976288x1600939808x1769172816x1852795252x1881160992x1953067887x997093225x538976266x1702109216x1920300152x1869562725x1852400754x543519841x1852383293x1416918384x1970567269x1866687858x1768190575x1702125934x997816366x175972362x"), BaseFilter.nativeDecrypt("mee1164x1667592816x1869181801x1768431726x544237671x1634692198x537541492x2037539190x543649385x845374838x2019914784x1701999988x1919905603x1634625892x171664756x1768846624x1836216166x1835103008x1919249520x1763722290x1953853550x1734438217x2019906661x1701999988x537541426x1718185589x544043631x1634692198x813244532x1965034043x1868982638x1713401202x1952542572x1920234272x1752458085x1769234770x537541487x1718185589x544043631x544501353x2003789939x1802658125x1965034043x1868982638x1763732850x1965061230x1969644915x537541484x1684631414x1767992608x170469486x537557792x538976288x673212009x1717924725x1025535093x691019837x537557792x538976288x538976288x1180658791x1130848626x1919904879x1948269856x1970567269x1144153458x1886284072x1833530485x1415931745x1970567269x741500274x2019914784x1701999988x1919905603x1634625892x992568692x538976266x538976288x1701978144x1852994932x538970683x2099257376x538970634x1713381408x1952542572x1917810976x1852401513x1948269856x1970567269x1866687858x1768190575x1702125934x171669806x538976288x1869375008x2032170081x997680462x538970634x1763713056x2032672870x1734963791x1008758377x691042592x537557792x538976288x538976288x2003127929x2032155936x1734963791x171667049x538976288x1696628000x543519596x537528955x538976288x538976288x1634692198x544481396x1333338173x1768384882x539828334x171651193x538976288x538976288x1869375008x1948284001x540876850x808333608x2032151840x706750768x774973472x539697200x1701999731x1382577251x1869182049x537541417x538976288x538976288x1634692198x829694068x1948269856x539631666x993144368x538976266x538976288x1818632224x544498031x1025520248x808333600x2032151840x537541424x538976288x538976288x1634692198x813047924x824196384x171651118x538976288x538976288x1869375008x1981838433x540876849x540178472x813047853x808333871x691106858x673197856x757084788x791770144x691023410x538970683x538976288x1713381408x1952542572x1025532192x829827104x1981820192x790636848x993096736x538976266x538976288x1818632224x544498031x537541496x538976288x538976288x673212009x540811380x539570548x538970747x538976288x538976288x2015371296x1981824288x539631664x539697268x540356144x543236138x544481322x997466154x538976266x538976288x545071136x1702063205x537557792x538976288x538976288x538976288x540876920x540356144x1982341162x539697200x539570550x829693994x1981819680x539631665x757101608x691106848x538970683x538976288x2099257376x538976266x538976288x1316560928x1025537893x540047648x997728299x538970634x2099257376x538970634x1730158624x1917214572x1866688353x544370540x1702109245x1920300152x675557989x1970302569x1634552180x1700029799x1920300152x539767397x845374838x2019914792x1701999988x1919905603x1634625892x2016306548x1316560940x690583397x168430139x538976288x543582496x1869116200x1918979447x1027416171x539570464x538970747x538976288x1763713056x2032672870x1734963791x1042312809x540047648x774905901x540094512x2032150054x1734963791x1008758377x540047648x774905899x691089456x537557792x538976288x538976288x538976288x1180658791x1130848626x1919904879x1981824288x674521957x741355057x808333344x774905900x824192048x992555054x538976266x538976288x175972384x538976288x168459552x168459552x"));
    int i = 0;
    this.legLineStable = false;
    this.lineMax = 1.0F;
    this.lineMin = 1.0F;
    this.rangeMax = 0.1F;
    this.timesForChangeToStable = 3000L;
    this.timesForChangeToUnstable = 3000L;
    this.previousTimeForChangeToStable = System.currentTimeMillis();
    this.previousTimeForChangeToUnstable = System.currentTimeMillis();
    this.previousLostWaistTime = System.currentTimeMillis();
    this.hasSeenValidPoints = false;
    this.curY0 = 0.0F;
    this.curStrength = 0.0F;
    initParams();
    this.previousWaistLines = new float[8];
    while (i < 8)
    {
      this.previousWaistLines[i] = 1.0F;
      i += 1;
    }
  }
  
  private int getCurrentFrame()
  {
    if (this.currentFrame >= 8) {
      this.currentFrame = 0;
    }
    return this.currentFrame;
  }
  
  private float getCurrentSmoothedWaistLine()
  {
    float f = 0.0F;
    int i = 0;
    while (i < 8)
    {
      f += this.previousWaistLines[i];
      i += 1;
    }
    return f / 8.0F;
  }
  
  private float legLineToset(float paramFloat)
  {
    if (!this.hasSeenValidPoints) {
      return 1.0F;
    }
    long l = System.currentTimeMillis();
    if (this.legLineStable)
    {
      f1 = (this.lineMin + this.lineMax) / 2.0F;
      if (Math.abs(f1 - paramFloat) < this.rangeMax)
      {
        this.previousTimeForChangeToUnstable = l;
      }
      else if (l - this.previousTimeForChangeToUnstable >= this.timesForChangeToUnstable)
      {
        int i = 0;
        this.legLineStable = false;
        this.previousTimeForChangeToStable = l;
        this.lineMax = paramFloat;
        this.lineMin = paramFloat;
        while (i < 8)
        {
          this.previousWaistLines[i] = f1;
          i += 1;
        }
      }
      return f1;
    }
    float f1 = this.lineMin;
    if (f1 >= paramFloat) {
      f1 = paramFloat;
    }
    this.lineMin = f1;
    f1 = this.lineMax;
    if (f1 <= paramFloat) {
      f1 = paramFloat;
    }
    this.lineMax = f1;
    f1 = this.lineMax;
    float f2 = this.lineMin;
    float f3 = this.rangeMax;
    if (f1 - f2 > f3)
    {
      this.lineMax = paramFloat;
      this.lineMin = paramFloat;
      this.previousTimeForChangeToStable = l;
      return paramFloat;
    }
    if (l - this.previousTimeForChangeToStable >= this.timesForChangeToStable)
    {
      this.legLineStable = true;
      this.lineMin = (paramFloat - f3 / 2.0F);
      this.lineMax = (f3 / 2.0F + paramFloat);
      this.previousTimeForChangeToUnstable = l;
    }
    return paramFloat;
  }
  
  private void setY0(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat > 1.0F) {
      f = 1.0F;
    }
    paramFloat = f;
    if (f < 0.0F) {
      paramFloat = 0.0F;
    }
    addParam(new UniformParam.FloatParam("y0", paramFloat));
    this.curY0 = paramFloat;
  }
  
  public LongLegParam getParam()
  {
    return new LongLegParam(this.curY0, this.curStrength);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.FloatParam("y0", 0.5F));
    addParam(new UniformParam.FloatParam("strecthRatio", 0.0F));
    addParam(new UniformParam.IntParam("showMark", 0));
    addParam(new UniformParam.IntParam("useful", 1));
  }
  
  public void setParam(LongLegParam paramLongLegParam)
  {
    addParam(new UniformParam.FloatParam("y0", paramLongLegParam.longLegY0));
    addParam(new UniformParam.FloatParam("strecthRatio", paramLongLegParam.longLegStrength));
  }
  
  public void setStrength(float paramFloat)
  {
    paramFloat *= 0.16F;
    addParam(new UniformParam.FloatParam("strecthRatio", paramFloat));
    this.curStrength = paramFloat;
  }
  
  public void setWaistLine(float paramFloat)
  {
    setWaistLine(paramFloat, true);
  }
  
  public void setWaistLine(float paramFloat, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if (paramFloat < 0.0F)
    {
      if ((!this.legLineStable) && (l - this.previousLostWaistTime < this.usePreviousIfWithin))
      {
        f = this.previousValidWaistLine;
        this.previousTimeForChangeToStable = System.currentTimeMillis();
      }
      else
      {
        f = 1.0F;
      }
    }
    else
    {
      this.previousValidWaistLine = paramFloat;
      this.previousLostWaistTime = l;
      f = paramFloat;
      if (!this.hasSeenValidPoints)
      {
        this.hasSeenValidPoints = true;
        this.previousTimeForChangeToStable = System.currentTimeMillis();
        f = paramFloat;
      }
    }
    this.previousWaistLines[getCurrentFrame()] = f;
    this.currentFrame += 1;
    if (paramBoolean) {
      f = legLineToset(getCurrentSmoothedWaistLine());
    }
    paramFloat = f;
    if (f > 1.0F) {
      paramFloat = 1.0F;
    }
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    addParam(new UniformParam.FloatParam("y0", f));
  }
  
  public void setWaistLine(List<PointF> paramList, int paramInt)
  {
    setWaistLine(paramList, paramInt, true);
  }
  
  public void setWaistLine(List<PointF> paramList, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      long l = System.currentTimeMillis();
      float f2;
      float f1;
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        f2 = (((PointF)paramList.get(15)).y + ((PointF)paramList.get(43)).y) / 2.0F / paramInt;
        this.previousValidWaistLine = f2;
        this.previousLostWaistTime = l;
        f1 = f2;
        if (!this.hasSeenValidPoints)
        {
          this.hasSeenValidPoints = true;
          this.previousTimeForChangeToStable = System.currentTimeMillis();
          f1 = f2;
        }
      }
      else
      {
        f2 = 1.0F;
        f1 = f2;
        if (!this.legLineStable)
        {
          f1 = f2;
          if (l - this.previousLostWaistTime < this.usePreviousIfWithin)
          {
            f1 = this.previousValidWaistLine;
            this.previousTimeForChangeToStable = System.currentTimeMillis();
          }
        }
      }
      this.previousWaistLines[getCurrentFrame()] = f1;
      this.currentFrame += 1;
      setY0(legLineToset(getCurrentSmoothedWaistLine()));
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty())) {
      setY0((((PointF)paramList.get(15)).y + ((PointF)paramList.get(43)).y) / 2.0F / paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.LongLegFilter
 * JD-Core Version:    0.7.0.1
 */