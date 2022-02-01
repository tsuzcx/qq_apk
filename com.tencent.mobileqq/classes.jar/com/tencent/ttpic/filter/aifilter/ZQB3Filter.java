package com.tencent.ttpic.filter.aifilter;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.ttpic.GPUImageLookupFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.view.RendererUtils;
import java.io.File;
import java.util.List;

public class ZQB3Filter
  extends BaseFilter
{
  private static String FRAGMENT_SHADER = "mee1538x1667592816x1869181801x1768431726x544237671x1634692198x1980382068x1769566817x1746954094x1885890409x1667593760x1702109234x1920300152x1869562725x1852400754x996504673x1853164042x1919903337x1634934893x1701605485x541340274x1970302569x1634552180x1700029799x1920300152x1963604837x1868982638x1931505010x1819307361x1144156773x1886284064x1833530485x1415931745x1970567269x993158514x1768846602x1836216166x2003790880x1852383344x2019893364x1952671088x1701011782x1963597883x1868982638x1746955634x1885890409x1667593760x1634082866x1698915683x1919251566x1853164091x1919903337x1768431725x544237671x1634692198x1634869364x1937074532x1963604812x1868982638x1746955634x1885890409x1869375008x1914729569x1969841249x993088371x1768846602x1836216166x1734961184x1713401960x1952542572x1684107808x1400075625x1963604786x1868982638x1746955634x1885890409x1869375008x1998615649x1752458345x1853164091x1919903337x1768431725x544237671x1634692198x1701322868x1952999273x1853164091x1919903337x1768431725x544237671x845374838x1667593760x1282568052x1853164091x1919903337x1768431725x544237671x845374838x1667593760x1400008564x1980369467x543451503x1852399981x2064263464x538976266x1667593760x1919885364x1852401513x1869377347x540876914x1954047348x845509237x1852385348x1232369008x1701273965x1954047316x744845941x2019914784x1701999988x1919905603x1634625892x992568692x538976266x1667593760x1970020404x1819231092x1025536623x2019914784x1701999988x1764246578x1953853550x1734438217x2019906661x1701999988x1948265522x1970567269x1866687858x1768190575x1702125934x537541417x1713381408x1952542572x1684369952x1864383776x1768384882x1819231086x2016309871x537534523x1713381408x1952542572x1701996320x1025535589x1769107232x1131309415x1919904879x540768558x538976266x1869375008x1646294113x543520108x1919885373x1852401513x1869377347x997863026x538970656x1818632224x544498031x540876897x993013297x538970656x1718165536x2019895328x1952671088x1701011782x540884256x640032817x1667327520x1852130149x779249012x540942456x540028464x1713382950x1130718049x1702129253x544812658x774905918x2065705264x538970656x538976288x1818632224x544498031x540876920x1954047348x1130721909x1685221231x1952542313x544747109x1769414698x996701284x538976266x538976288x1869375008x2032170081x1948269856x1970567269x1866687858x1768190575x1702125934x706771246x1768253472x997484647x538976266x538976288x1667593760x1768169522x540876915x845374838x1714255912x1130718049x1702129253x746073714x1714256160x1130718049x1702129253x695807602x538970683x538976288x1818632224x544498031x1953720676x540876876x779315556x539631736x1952671094x776761967x539697272x779315556x539631737x1952671094x776761967x169884537x538976288x538976288x1634692198x1768169588x542340211x1768169533x544747123x1702240298x1919906915x544747091x1768169515x544812659x1702240298x1919906915x997797459x538970656x538976288x1818632224x544498031x1025528690x1684107808x1400075625x169884465x538976288x538976288x673212009x1953720676x540942419x691023408x169900832x538976288x538976288x538976288x1025528690x1684107808x1400075625x169884466x538976288x538976288x537534589x538976288x1713381408x1952542572x1936286752x540876916x1936286760x790645876x1684107808x1282635113x539631657x1936286760x790645876x1684107808x1282635113x539697193x1936286760x790647668x693334560x673196576x1953720676x539959379x992564082x538970656x538976288x1718165536x1936286760x1027350644x959328288x175841321x538976288x538976288x538976288x540876897x993013296x538970656x538976288x545071136x1702063205x543582496x1936286760x1027350644x808333600x175841321x538976288x538976288x538976288x540876897x1936286760x539828340x691613232x824191520x993013296x538970656x538976288x545071136x538976266x537558304x1713381408x1952542572x2003136032x543450450x1702109245x1920300152x675557989x1970302569x1634552180x1700029799x1920300152x1948265573x1970567269x1866687858x1768190575x1702125934x1981819680x674390885x825241136x774905900x774449456x169884536x538976288x543450482x1768759357x1701980280x1847602276x1699903333x1629498468x169884457x538976288x1180658791x1130848626x1919904879x1981824288x674521957x744777074x1953852448x1869377347x744959602x1953852448x1869377347x744631922x1769107232x1131309415x1919904879x992567598x32010x";
  private int expectFace = 1;
  private float[] faceCenter = { 0.0F, 0.0F };
  private GPUImageLookupFilter mGpuImageLookupFilter = new GPUImageLookupFilter();
  private Frame mGpuLookupFrame = new Frame();
  private float radiusL = 0.0F;
  private float radiusS1 = 0.0F;
  private float radiusS2 = 0.0F;
  private byte[] rgbaBuffer;
  private float[] vectorL = { 0.0F, 1.0F };
  private float[] vectorS = { 1.0F, 0.0F };
  
  public ZQB3Filter(String paramString)
  {
    super(FRAGMENT_SHADER);
    Context localContext = AEModule.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("lut.png");
    paramString = BitmapUtils.getBitmapFromEncryptedFile(localContext, localStringBuilder.toString());
    this.mGpuImageLookupFilter.addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", paramString, 33986, true));
    addParam(new UniformParam.IntParam("expectFace", this.expectFace));
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33987));
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
    this.mGpuImageLookupFilter.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
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
    this.mGpuImageLookupFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, this.mGpuLookupFrame);
    addParam(new UniformParam.TextureParam("inputImageTexture2", this.mGpuLookupFrame.getTextureId(), 33987));
    super.beforeRender(paramInt1, paramInt2, paramInt3);
  }
  
  public void clearGLSL()
  {
    this.mGpuImageLookupFilter.clearGLSL();
    this.mGpuLookupFrame.clear();
    super.clearGLSL();
  }
  
  public void clearGLSLSelf()
  {
    this.mGpuImageLookupFilter.clearGLSLSelf();
    this.mGpuLookupFrame.clear();
    super.clearGLSLSelf();
  }
  
  public void setExceptFace(int paramInt)
  {
    this.expectFace = paramInt;
    addParam(new UniformParam.IntParam("expectFace", paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.ZQB3Filter
 * JD-Core Version:    0.7.0.1
 */