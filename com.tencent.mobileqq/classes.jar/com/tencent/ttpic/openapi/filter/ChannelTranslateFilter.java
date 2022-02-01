package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.view.RendererUtils;
import java.util.List;

public class ChannelTranslateFilter
  extends BaseFilter
{
  private static String FRAGMENT_SHADER = "mee2052x1667592816x1869181801x1768431726x544237671x1634692198x1980382068x1769566817x1746954094x1885890409x1667593760x1702109234x1920300152x1869562725x1852400754x996504673x1853164042x1919903337x1634934893x1701605485x541340274x1970302569x1634552180x1700029799x1920300152x1963604837x1868982638x1713401202x1952542572x1684369952x1963604824x1868982638x1713401202x1952542572x1684369952x1963604825x1868982638x1713401202x1952542572x1701996320x995651173x1768846602x1836216166x1869375008x1730180193x1852138866x1963604825x1868982638x1713401202x1952542572x1970037280x171661413x1718185589x544043631x1634692198x1818370164x995714421x1768846602x1836216166x2003790880x1852383344x2019893364x1952671088x1701011782x1963597883x1868982638x1746955634x1885890409x1667593760x1634082866x1698915683x1919251566x1853164091x1919903337x1768431725x544237671x1634692198x1634869364x1937074532x1963604812x1868982638x1746955634x1885890409x1869375008x1914729569x1969841249x993088371x1768846602x1836216166x1734961184x1713401960x1952542572x1684107808x1400075625x1963604786x1868982638x1746955634x1885890409x1869375008x1998615649x1752458345x1853164091x1919903337x1768431725x544237671x1634692198x1701322868x1952999273x1853164091x1919903337x1768431725x544237671x845374838x1667593760x1282568052x1853164091x1919903337x1768431725x544237671x845374838x1667593760x1400008564x1980369467x543451503x1852399981x2064263464x538976266x1667593760x1919885364x1852401513x1869377347x540876914x1954047348x845509237x1852385348x1232369008x1701273965x1954047316x744845941x2019914784x1701999988x1919905603x1634625892x992568692x538976266x1869375008x1914729569x1025533029x1769107232x1131309415x1919904879x540768302x538976266x1869375008x1730180193x1852138866x1864383776x1768384882x1819231086x2033087087x537534523x1713381408x1952542572x1970037280x540876901x1734963823x1866690153x779251564x169884538x538976288x1634692198x1701716084x1684361847x1864383776x1768384882x1819231086x2016309871x537534523x1713381408x1952542572x2003136032x1701147207x540876910x1734963823x1866690153x779251564x169884537x538976288x1634692198x1701716084x1970029175x540876901x1734963823x1866690153x779251564x169884538x538976288x1634692198x543236212x774971453x169884464x538976288x673212009x1701869669x1632007267x1025533283x540090429x1713382950x1130718049x1702129253x544747122x774905918x640032816x1667327520x1852130149x779249012x540942457x691023408x169900832x538976288x538976288x1634692198x544743540x1702109245x1920300152x1869562725x1852400754x778400865x539631736x1952737655x537541480x538976288x1713381408x1952542572x1025538336x2019914784x1701999988x1919905603x1634625892x2033083764x1746938400x1751607653x537541492x538976288x1981816864x540173157x544434532x1702240317x2015900259x1667327533x1852130149x779249012x2032151672x1667327533x1852130149x779249012x171649401x538976288x538976288x1634692198x1768169588x541881459x1768169533x544747123x1702240298x1919906915x544747084x1768169515x544812659x1702240298x1919906915x997797452x538970656x538976288x1818632224x544498031x1953720676x540876883x779315556x539631736x1952671094x777220719x539697272x779315556x539631737x1952671094x777220719x169884537x538976288x538976288x1634692198x1399988340x1914715424x1969841249x993088371x538970656x538976288x1718165536x1768171552x542340211x774905918x2065705264x538970656x538976288x538976288x1399988256x1914715424x1969841249x993153907x538970656x538976288x545071136x538976266x538976288x1869375008x1679848545x544502633x1680351293x1282700137x1914711840x1969841249x539577459x1680351274x1282700137x1914711840x1969841249x539577459x1680351275x1400140649x1914711840x706750803x1768171552x542340211x1399988271x169884457x538976288x538976288x1680369257x544502633x807419196x539572526x538970747x538976288x538976288x543236128x774905917x169884464x538976288x538976288x1818566781x1763730803x1680351334x544502633x824196412x539570222x538970747x538976288x538976288x543236128x1680351293x544502633x774905901x706750777x774910240x169884464x538976288x538976288x537534589x2099257376x538976266x543582496x1684369960x1025581144x808333344x545029152x1499751794x540877088x691023408x169900832x538976288x538976288x1383556462x1025533029x2019914784x1701999988x1764246578x1953853550x1734438217x2019906661x1701999988x1702109228x1920300152x1869562725x1852400754x543519841x1702240299x1915236963x743990373x1684369952x774449497x169884536x538976288x537534589x1763713056x1730682982x1852138866x1025581144x808333344x545029152x1701147239x555768174x774905917x2065705264x538970656x538976288x1701716000x1701988215x1025535589x2019914784x1701999988x1764246578x1953853550x1734438217x2019906661x1701999988x1702109228x1920300152x1869562725x1852400754x543519841x1702240299x1730687587x1852138866x1730161752x1852138866x774449497x169884537x538976288x537534589x1763713056x1646796902x1483044204x540877088x540028464x1646296188x1499821420x540877088x691023408x169900832x538976288x538976288x1115121006x543520108x1702109245x1920300152x675557989x1970302569x1634552180x1700029799x1920300152x1948265573x1970567269x1866687858x1768190575x1702125934x1981819680x674390885x1702194274x1646275672x1499821420x2049845545x537534523x2099257376x538970656x1701978144x540876900x678979949x744777074x2003136032x744777042x992567584x538976266x1701996320x1025535589x2020175136x1701996328x539782757x1199007086x1852138866x694231084x538970683x1818370080x1025533301x2020175136x1970037288x1847602277x1816295269x539780469x171649377x538976266x1600939808x1734439494x1869377347x540876914x878929270x1684369960x1919361068x745432421x1970037280x1864379493x1768384882x1819231086x1630433903x2097822505x";
  private int expectFace = 1;
  private float[] faceCenter = { 0.0F, 0.0F };
  private float radiusL = 0.0F;
  private float radiusS1 = 0.0F;
  private float radiusS2 = 0.0F;
  private byte[] rgbaBuffer;
  private float[] vectorL = { 0.0F, 1.0F };
  private float[] vectorS = { 1.0F, 0.0F };
  
  public ChannelTranslateFilter()
  {
    super(FRAGMENT_SHADER);
    initParams();
  }
  
  private void initParams()
  {
    addParam(new UniformParam.FloatParam("redX", 0.0F));
    addParam(new UniformParam.FloatParam("redY", 0.0F));
    addParam(new UniformParam.FloatParam("greenX", 0.0F));
    addParam(new UniformParam.FloatParam("greenY", 0.0F));
    addParam(new UniformParam.FloatParam("blueX", 0.0F));
    addParam(new UniformParam.FloatParam("blueY", 0.0F));
    addParam(new UniformParam.IntParam("expectFace", this.expectFace));
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.FloatsParam("faceCenter", this.faceCenter));
    addParam(new UniformParam.FloatParam("radiusL", this.radiusL));
    addParam(new UniformParam.FloatParam("radiusS1", this.radiusS1));
    addParam(new UniformParam.FloatParam("radiusS2", this.radiusS2));
    addParam(new UniformParam.FloatsParam("vectorL", this.vectorL));
    addParam(new UniformParam.FloatsParam("vectorS", this.vectorS));
    addParam(new UniformParam.FloatParam("width", paramFloat1));
    addParam(new UniformParam.FloatParam("height", paramFloat2));
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.expectFace == 1)
    {
      Object localObject1 = this.rgbaBuffer;
      if ((localObject1 == null) || (localObject1.length != paramInt2 * paramInt3 * 4)) {
        this.rgbaBuffer = new byte[paramInt2 * paramInt3 * 4];
      }
      localObject1 = new int[1];
      GLES20.glGenFramebuffers(1, (int[])localObject1, 0);
      RendererUtils.saveTextureToRgbBuffer(paramInt1, paramInt2, paramInt3, this.rgbaBuffer, localObject1[0]);
      Object localObject2 = new VideoPreviewFaceOutlineDetector();
      ((VideoPreviewFaceOutlineDetector)localObject2).init();
      ((VideoPreviewFaceOutlineDetector)localObject2).doFaceDetect(this.rgbaBuffer, paramInt2, paramInt3);
      ((VideoPreviewFaceOutlineDetector)localObject2).doTrack(this.rgbaBuffer, paramInt2, paramInt3);
      List localList = ((VideoPreviewFaceOutlineDetector)localObject2).getAllPoints(0);
      ((VideoPreviewFaceOutlineDetector)localObject2).destroy();
      if (localList != null)
      {
        if (localList.size() <= 88) {
          return;
        }
        localObject2 = new Rect();
        ((Rect)localObject2).left = ((int)((PointF)localList.get(86)).x);
        ((Rect)localObject2).top = ((int)Math.min(((PointF)localList.get(86)).y, ((PointF)localList.get(88)).y));
        ((Rect)localObject2).right = ((int)((PointF)localList.get(88)).x);
        ((Rect)localObject2).bottom = ((int)((PointF)localList.get(9)).y);
        if (((Rect)localObject2).left < 0) {
          ((Rect)localObject2).left = 0;
        }
        if (((Rect)localObject2).top < 0) {
          ((Rect)localObject2).top = 0;
        }
        if (((Rect)localObject2).right > paramInt2) {
          ((Rect)localObject2).right = paramInt2;
        }
        if (((Rect)localObject2).bottom > paramInt3) {
          ((Rect)localObject2).bottom = paramInt3;
        }
        this.faceCenter[0] = ((Rect)localObject2).centerX();
        this.faceCenter[1] = ((Rect)localObject2).centerY();
        this.radiusL = ((float)Math.sqrt((((PointF)localList.get(9)).x - this.faceCenter[0]) * (((PointF)localList.get(9)).x - this.faceCenter[0]) + (((PointF)localList.get(9)).y - this.faceCenter[1]) * (((PointF)localList.get(9)).y - this.faceCenter[1])) * 1.05F);
        addParam(new UniformParam.FloatsParam("faceCenter", this.faceCenter));
        addParam(new UniformParam.FloatParam("radiusL", this.radiusL));
        this.vectorL[0] = (((PointF)localList.get(9)).x - ((Rect)localObject2).centerX());
        this.vectorL[1] = (((PointF)localList.get(9)).y - ((Rect)localObject2).centerY());
        localObject2 = this.vectorL;
        float f = (float)Math.sqrt(localObject2[0] * localObject2[0] + localObject2[1] * localObject2[1]);
        if (f > 0.0F)
        {
          localObject2 = this.vectorL;
          localObject2[0] /= f;
          localObject2[1] /= f;
        }
        addParam(new UniformParam.FloatsParam("vectorL", this.vectorL));
        localObject2 = this.vectorS;
        float[] arrayOfFloat = this.vectorL;
        localObject2[0] = arrayOfFloat[1];
        localObject2[1] = (-arrayOfFloat[0]);
        addParam(new UniformParam.FloatsParam("vectorS", (float[])localObject2));
        this.radiusS1 = (Math.abs((((PointF)localList.get(0)).x - this.faceCenter[0]) * this.vectorS[0] + (((PointF)localList.get(0)).y - this.faceCenter[1]) * this.vectorS[1]) * 1.05F);
        this.radiusS2 = (Math.abs((((PointF)localList.get(18)).x - this.faceCenter[0]) * this.vectorS[0] + (((PointF)localList.get(18)).y - this.faceCenter[1]) * this.vectorS[1]) * 1.05F);
        addParam(new UniformParam.FloatParam("radiusS1", this.radiusS1));
        addParam(new UniformParam.FloatParam("radiusS2", this.radiusS2));
        GLES20.glDeleteFramebuffers(1, (int[])localObject1, 0);
      }
      else
      {
        return;
      }
    }
    super.beforeRender(paramInt1, paramInt2, paramInt3);
  }
  
  public void setBlueX(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("blueX", paramFloat));
  }
  
  public void setBlueY(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("blueY", paramFloat));
  }
  
  public void setExceptFace(int paramInt)
  {
    this.expectFace = paramInt;
    addParam(new UniformParam.IntParam("expectFace", paramInt));
  }
  
  public void setGreenX(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("greenX", paramFloat));
  }
  
  public void setGreenY(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("greenY", paramFloat));
  }
  
  public void setRedX(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("redX", paramFloat));
  }
  
  public void setRedY(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("redY", paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.ChannelTranslateFilter
 * JD-Core Version:    0.7.0.1
 */