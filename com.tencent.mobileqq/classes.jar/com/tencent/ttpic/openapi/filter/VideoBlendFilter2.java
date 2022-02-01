package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.util.AlgoUtils;

public class VideoBlendFilter2
  extends BaseFilter
{
  private static final String FRAGREMENT_SHADER = "mee437x1701998624x1769171299x1746955887x1885890409x1869375008x171668577x1918989856x1735289209x1667593760x1633886258x1935767150x1919905603x1634625892x171664756x1918989856x1735289209x1667593760x1702109234x1920300152x1869562725x1852400754x996504673x1853169674x1919903337x1634934893x1701605485x541340274x1970302569x1634552180x1700029799x1920300152x537541477x1718185589x544043631x1886216563x846357868x1852383300x1232369008x1701273965x1954047316x845509237x1965034043x1868982638x1763732850x1646294126x1684956524x1701080941x1981811259x543451503x1852399981x537536808x538970747x1981816864x540304229x1025519971x2019914784x1701999988x1764246578x1953853550x1734438217x2019906661x1701999988x1948265522x1970567269x1866687858x1768190575x1702125934x537541417x538976288x878929270x540173088x1702109245x1920300152x675557989x1970302569x1634552180x1700029799x1920300152x1663052901x1635151457x1869562739x1852400754x694514785x538970683x1763713056x1818372198x1835298405x543515759x807419197x537557801x538976288x1730158624x1917214572x1866688353x544370540x845357117x538970683x2099257376x1936483616x175841381x538976288x538976288x1180658791x1130848626x1919904879x1663057184x537541425x538976288x175966845x10x";
  private static final String VERTEX_SHADER = "mee319x1667592816x1869181801x1768431726x544237671x1634692198x1628060532x1769108596x1702131042x1667593760x1869619252x1769236851x171667055x1920234593x1953849961x1702240357x1763717731x1953853550x1954047316x1130721909x1685221231x1952542313x1980382053x1769566817x1981835118x540173157x1986945379x1866691425x1768190575x1702125934x1635125819x1852406130x1702240359x1948267107x1970567269x1866687858x1768190575x1702125934x1980369467x543451503x1852399981x175843624x538976288x1348430951x1953067887x544108393x1869619261x1769236851x171667055x538976288x1986945379x1866691425x1768190575x1702125934x1981824288x674390885x1769172848x1852795252x706770990x892219424x807414560x539768110x1769172848x1852795252x706771246x892219424x807414560x992556334x538976266x2019914784x1701999988x1919905603x1634625892x1025533300x1886284064x1700033653x1920300152x1869562725x1852400754x996504673x687370x";
  private int blendmode;
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame mCopyFrame = new Frame();
  private float[] position = GlUtil.ORIGIN_POSITION_COORDS;
  private Bitmap watermarkBitmap = null;
  private int watermarkHeight;
  private int watermarkWidth;
  
  public VideoBlendFilter2()
  {
    super("mee319x1667592816x1869181801x1768431726x544237671x1634692198x1628060532x1769108596x1702131042x1667593760x1869619252x1769236851x171667055x1920234593x1953849961x1702240357x1763717731x1953853550x1954047316x1130721909x1685221231x1952542313x1980382053x1769566817x1981835118x540173157x1986945379x1866691425x1768190575x1702125934x1635125819x1852406130x1702240359x1948267107x1970567269x1866687858x1768190575x1702125934x1980369467x543451503x1852399981x175843624x538976288x1348430951x1953067887x544108393x1869619261x1769236851x171667055x538976288x1986945379x1866691425x1768190575x1702125934x1981824288x674390885x1769172848x1852795252x706770990x892219424x807414560x539768110x1769172848x1852795252x706771246x892219424x807414560x992556334x538976266x2019914784x1701999988x1919905603x1634625892x1025533300x1886284064x1700033653x1920300152x1869562725x1852400754x996504673x687370x", "mee437x1701998624x1769171299x1746955887x1885890409x1869375008x171668577x1918989856x1735289209x1667593760x1633886258x1935767150x1919905603x1634625892x171664756x1918989856x1735289209x1667593760x1702109234x1920300152x1869562725x1852400754x996504673x1853169674x1919903337x1634934893x1701605485x541340274x1970302569x1634552180x1700029799x1920300152x537541477x1718185589x544043631x1886216563x846357868x1852383300x1232369008x1701273965x1954047316x845509237x1965034043x1868982638x1763732850x1646294126x1684956524x1701080941x1981811259x543451503x1852399981x537536808x538970747x1981816864x540304229x1025519971x2019914784x1701999988x1764246578x1953853550x1734438217x2019906661x1701999988x1948265522x1970567269x1866687858x1768190575x1702125934x537541417x538976288x878929270x540173088x1702109245x1920300152x675557989x1970302569x1634552180x1700029799x1920300152x1663052901x1635151457x1869562739x1852400754x694514785x538970683x1763713056x1818372198x1835298405x543515759x807419197x537557801x538976288x1730158624x1917214572x1866688353x544370540x845357117x538970683x2099257376x1936483616x175841381x538976288x538976288x1180658791x1130848626x1919904879x1663057184x537541425x538976288x175966845x10x");
    initParams();
  }
  
  private void setBlendMode(int paramInt)
  {
    this.blendmode = paramInt;
    addParam(new UniformParam.IntParam("blendmode", paramInt));
  }
  
  public void apply()
  {
    super.apply();
    setPositions(this.position);
    setTexCords(GlUtil.ORIGIN_TEX_COORDS_REVERSE);
    this.mCopyFilter.apply();
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    this.mCopyFilter.clearGLSLSelf();
    this.mCopyFrame.clear();
    Bitmap localBitmap = this.watermarkBitmap;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.watermarkBitmap = null;
    }
  }
  
  public int getWatermarkHeight()
  {
    return this.watermarkHeight;
  }
  
  public int getWatermarkWidth()
  {
    return this.watermarkWidth;
  }
  
  public void initParams()
  {
    addParam(new UniformParam.IntParam("blendmode", 0));
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
  }
  
  public boolean needRender()
  {
    return this.blendmode != 0;
  }
  
  public Frame renderWatermark(Frame paramFrame)
  {
    GlUtil.setBlendMode(true);
    Frame localFrame = this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
    OnDrawFrameGLSL();
    renderTexture(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
    GlUtil.setBlendMode(false);
    paramFrame.unlock();
    return localFrame;
  }
  
  public Frame renderWatermarkNoCache(Frame paramFrame)
  {
    GlUtil.setBlendMode(true);
    this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mCopyFrame);
    OnDrawFrameGLSL();
    renderTexture(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
    GlUtil.setBlendMode(false);
    paramFrame.unlock();
    return this.mCopyFrame;
  }
  
  public void setGridWatermarkPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f;
    if (paramInt3 <= paramInt4) {
      f = 750.0F;
    } else {
      f = 1334.0F;
    }
    int i = this.watermarkWidth;
    int j = (int)(i / f * paramInt3);
    setWatermarkPosition(paramInt1, paramInt2, j, this.watermarkHeight * j / i, paramInt3, paramInt4);
  }
  
  public void setWatermarkBitmap(Bitmap paramBitmap)
  {
    if (BitmapUtils.isLegal(paramBitmap))
    {
      getParam("inputImageTexture2").clear();
      this.watermarkWidth = paramBitmap.getWidth();
      this.watermarkHeight = paramBitmap.getHeight();
      Object localObject = this.watermarkBitmap;
      if (localObject != null)
      {
        ((Bitmap)localObject).recycle();
        this.watermarkBitmap = null;
      }
      this.watermarkBitmap = Bitmap.createBitmap(this.watermarkWidth, this.watermarkHeight, Bitmap.Config.ARGB_8888);
      localObject = new Canvas(this.watermarkBitmap);
      Paint localPaint = new Paint();
      ((Canvas)localObject).drawBitmap(paramBitmap, new Matrix(), localPaint);
      paramBitmap = new UniformParam.TextureBitmapParam("inputImageTexture2", this.watermarkBitmap, 33986, false);
      addParam(paramBitmap);
      paramBitmap.initialParams(getProgramIds());
      setBlendMode(1);
      return;
    }
    this.watermarkHeight = 0;
    this.watermarkWidth = 0;
    setBlendMode(0);
  }
  
  public void setWatermarkPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.position = AlgoUtils.calPositions(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, paramInt5, paramInt6);
    setPositions(this.position);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.VideoBlendFilter2
 * JD-Core Version:    0.7.0.1
 */