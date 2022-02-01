package com.tencent.ttpic.openapi.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.ttpic.AutoLevelFilter;
import com.tencent.filter.ttpic.BeautysRealAutoFilter;
import com.tencent.filter.ttpic.BlackWhite2Filter;
import com.tencent.filter.ttpic.BlackWhite3Filter;
import com.tencent.filter.ttpic.BlackWhite4Filter;
import com.tencent.filter.ttpic.BlackWhiteFilter;
import com.tencent.filter.ttpic.BlurHighRealFilter;
import com.tencent.filter.ttpic.ChongShengFilter;
import com.tencent.filter.ttpic.CoffeeFilter;
import com.tencent.filter.ttpic.DarkCornerPtuFilter;
import com.tencent.filter.ttpic.FaceBeautyAutoFilter;
import com.tencent.filter.ttpic.Fen2Filter;
import com.tencent.filter.ttpic.FenFilter;
import com.tencent.filter.ttpic.FengJngFilter;
import com.tencent.filter.ttpic.FuGuFilter;
import com.tencent.filter.ttpic.FuGuHuangFilter;
import com.tencent.filter.ttpic.GPUImageLookupFilter;
import com.tencent.filter.ttpic.GaoGuangLanZiFilter;
import com.tencent.filter.ttpic.GaoLengFilter;
import com.tencent.filter.ttpic.GradientAndyWarholCowFilter;
import com.tencent.filter.ttpic.GradientGlareFashionFilter;
import com.tencent.filter.ttpic.GradientGlareFondDreamFilter;
import com.tencent.filter.ttpic.GradientPurpleYellowFilter;
import com.tencent.filter.ttpic.HuaiJiuFilter;
import com.tencent.filter.ttpic.ImageAutoLevelGPUFilter;
import com.tencent.filter.ttpic.JiaoPianFilter;
import com.tencent.filter.ttpic.JingWuFilter;
import com.tencent.filter.ttpic.LanFilter;
import com.tencent.filter.ttpic.LanTuiSeFilter;
import com.tencent.filter.ttpic.LightRedFilter;
import com.tencent.filter.ttpic.LightWhiteFilter;
import com.tencent.filter.ttpic.LollyFilter;
import com.tencent.filter.ttpic.MedSeaFilter;
import com.tencent.filter.ttpic.MeishiFilter;
import com.tencent.filter.ttpic.MenghuanFilter;
import com.tencent.filter.ttpic.MilkBlueFilter;
import com.tencent.filter.ttpic.MilkCoffeeFilter;
import com.tencent.filter.ttpic.MilkGreenFilter;
import com.tencent.filter.ttpic.MoLvFilter;
import com.tencent.filter.ttpic.NaichaFilter;
import com.tencent.filter.ttpic.NextDoorFilter;
import com.tencent.filter.ttpic.NuanHuangFilter;
import com.tencent.filter.ttpic.PtuLengMeiRenFilter;
import com.tencent.filter.ttpic.PtuLinjiaFilter;
import com.tencent.filter.ttpic.PtuQingCongFilter;
import com.tencent.filter.ttpic.PtuShiGuangRenFilter;
import com.tencent.filter.ttpic.PtuShiShang2RenFilter;
import com.tencent.filter.ttpic.PtuWenYiFanFilter;
import com.tencent.filter.ttpic.QuanMinYIngDiFilter;
import com.tencent.filter.ttpic.RichBlueFilter;
import com.tencent.filter.ttpic.RichRedFilter;
import com.tencent.filter.ttpic.RichYellowFilter;
import com.tencent.filter.ttpic.SapporoFilter;
import com.tencent.filter.ttpic.SenlinFilter;
import com.tencent.filter.ttpic.ShiShangSHFilter;
import com.tencent.filter.ttpic.SnowFilter;
import com.tencent.filter.ttpic.TeaMilkFilter;
import com.tencent.filter.ttpic.ThreeDFilter;
import com.tencent.filter.ttpic.ThursdayFilter;
import com.tencent.filter.ttpic.TianMeiZiPaiFilter;
import com.tencent.filter.ttpic.TransKongChengFilter;
import com.tencent.filter.ttpic.TransMeiWeiFilter;
import com.tencent.filter.ttpic.TransXinXianFilter;
import com.tencent.filter.ttpic.WeiZhiDaoFilters.KaFeiFilter;
import com.tencent.filter.ttpic.WeiZhiDaoFilters.MeiWeiFilter;
import com.tencent.filter.ttpic.WeiZhiDaoFilters.TianPinFilter;
import com.tencent.filter.ttpic.WeiZhiDaoFilters.XiCanFilter;
import com.tencent.filter.ttpic.WeiZhiDaoFilters.XinXianFilter;
import com.tencent.filter.ttpic.YoungFilter;
import com.tencent.ttpic.filter.BlurLutFilter;
import com.tencent.ttpic.openapi.factory.TTPicFilterFactoryLocal;

public class CameraFilterFactory
{
  public static final int MIC_PTU_CHENGJING = 2003;
  public static final int MIC_PTU_FEIHONG = 2013;
  public static final int MIC_PTU_FEILIN = 2017;
  public static final int MIC_PTU_HANFENG = 2010;
  public static final int MIC_PTU_JIAOCHA = 2016;
  public static final int MIC_PTU_JIAZHOU = 2011;
  public static final int MIC_PTU_LAODIANYING = 2005;
  public static final int MIC_PTU_LIANKONG = 2004;
  public static final int MIC_PTU_MEIWEI = 2007;
  public static final int MIC_PTU_MOKA = 2018;
  public static final int MIC_PTU_NAIXING = 2014;
  public static final int MIC_PTU_TIANPING = 2008;
  public static final int MIC_PTU_WU_BACK = 2019;
  public static final int MIC_PTU_WU_FRONT = 2020;
  public static final int MIC_PTU_XINXIAN = 2006;
  public static final int MIC_PTU_YAHUI = 2015;
  public static final int MIC_PTU_YANHONG = 2009;
  public static final int MIC_PTU_ZHIGAN = 3000;
  public static final int MIC_PTU_ZIRAN_BACK = 2002;
  public static final int MIC_PTU_ZIRAN_FRONT = 2001;
  
  private static BaseFilter creatFilterByIdForPudding(int paramInt)
  {
    if (paramInt != 246)
    {
      if (paramInt != 257)
      {
        if (paramInt != 268)
        {
          if (paramInt != 271)
          {
            if (paramInt != 273)
            {
              if (paramInt != 285)
              {
                if (paramInt != 287)
                {
                  if (paramInt != 314)
                  {
                    if (paramInt != 282)
                    {
                      if (paramInt != 283)
                      {
                        if (paramInt != 297)
                        {
                          if (paramInt != 298)
                          {
                            switch (paramInt)
                            {
                            default: 
                              BlurLutFilter localBlurLutFilter1;
                              BlurLutFilter localBlurLutFilter2;
                              switch (paramInt)
                              {
                              default: 
                                switch (paramInt)
                                {
                                default: 
                                  return null;
                                case 2020: 
                                  return new GPUImageLookupFilter("sh/wu_lf_front.png");
                                case 2019: 
                                  return new GPUImageLookupFilter("sh/wu_lf_back.png");
                                case 2018: 
                                  return new GPUImageLookupFilter("sh/MoKa.png");
                                case 2017: 
                                  return new GPUImageLookupFilter("sh/FeiLin.png");
                                case 2016: 
                                  return new GPUImageLookupFilter("sh/JiaoCha.png");
                                case 2015: 
                                  return new GPUImageLookupFilter("sh/YaHui.png");
                                case 2014: 
                                  return new GPUImageLookupFilter("sh/NaiXing.png");
                                }
                                return new GPUImageLookupFilter("sh/FeiHong.png");
                              case 2011: 
                                localBlurLutFilter1 = new BlurLutFilter();
                                localBlurLutFilter2 = (BlurLutFilter)localBlurLutFilter1;
                                localBlurLutFilter2.setLutTexture("sh/jiazhou.png");
                                localBlurLutFilter2.setBlendAplha(0.5F);
                                return localBlurLutFilter1;
                              case 2010: 
                                localBlurLutFilter1 = new BlurLutFilter();
                                localBlurLutFilter2 = (BlurLutFilter)localBlurLutFilter1;
                                localBlurLutFilter2.setLutTexture("sh/hanfeng.png");
                                localBlurLutFilter2.setBlendAplha(0.5F);
                                return localBlurLutFilter1;
                              case 2009: 
                                localBlurLutFilter1 = new BlurLutFilter();
                                localBlurLutFilter2 = (BlurLutFilter)localBlurLutFilter1;
                                localBlurLutFilter2.setLutTexture("sh/yanhong.png");
                                localBlurLutFilter2.setBlendAplha(0.5F);
                                return localBlurLutFilter1;
                              case 2008: 
                                return new GPUImageLookupFilter("sh/tianping.png");
                              case 2007: 
                                return new GPUImageLookupFilter("sh/meiwei.png");
                              case 2006: 
                                return new GPUImageLookupFilter("sh/xinxian.png");
                              case 2005: 
                                return new GPUImageLookupFilter("sh/laodianying.png");
                              case 2004: 
                                return new GPUImageLookupFilter("sh/liankong.png");
                              case 2003: 
                                return new GPUImageLookupFilter("sh/chengjing.png");
                              case 2002: 
                                return new GPUImageLookupFilter("sh/ziran_back.png");
                              }
                              return new GPUImageLookupFilter("sh/ziran_front.png");
                            case 310: 
                              return new GPUImageLookupFilter("sh/dannai_lf.png");
                            case 309: 
                              return new GPUImageLookupFilter("sh/muse_lf.png");
                            case 308: 
                              return new GPUImageLookupFilter("sh/chuxia_lf.png");
                            case 307: 
                              return new GPUImageLookupFilter("sh/gaobai_lf.png");
                            case 306: 
                              return new GPUImageLookupFilter("sh/xindong_lf.png");
                            }
                            return new GPUImageLookupFilter("sh/qingcheng_lf.png");
                          }
                          return new GPUImageLookupFilter("sh/qingxi_lf.png");
                        }
                        return new GPUImageLookupFilter("sh/wuxia_lf.png");
                      }
                      return new GPUImageLookupFilter("sh/qiangwei_lf.png");
                    }
                    return new GPUImageLookupFilter("sh/BaiXi.png");
                  }
                  return new GPUImageLookupFilter("sh/zhongxing_lf.png");
                }
                return new GPUImageLookupFilter("sh/shuilian_lf.png");
              }
              return new GPUImageLookupFilter("sh/xinye_lf.png");
            }
            return new MoscoFilter();
          }
          return new GPUImageLookupFilter("sh/baicha_lf.png");
        }
        return new GPUImageLookupFilter("sh/mo_lf.png");
      }
      return new GPUImageLookupFilter("sh/dongjing_lf.png");
    }
    return new GPUImageLookupFilter("sh/meiguichuxue_lf.png");
  }
  
  public static BaseFilter createFilterById(int paramInt)
  {
    Object localObject2 = creatFilterByIdForPudding(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = TTPicFilterFactoryLocal.creatFilterById(paramInt);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }
    return localObject2;
  }
  
  public static BaseFilter createFilterById4Local(int paramInt)
  {
    Object localObject2 = creatFilterByIdForPudding(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = createFilterByIdForPitu(paramInt);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }
    return localObject2;
  }
  
  private static BaseFilter createFilterByIdForPitu(int paramInt)
  {
    if (paramInt != 200)
    {
      if (paramInt != 201)
      {
        if (paramInt != 215)
        {
          if (paramInt != 216)
          {
            if (paramInt != 219)
            {
              if (paramInt != 220)
              {
                if (paramInt != 269)
                {
                  if (paramInt != 270)
                  {
                    switch (paramInt)
                    {
                    default: 
                      switch (paramInt)
                      {
                      default: 
                        switch (paramInt)
                        {
                        default: 
                          switch (paramInt)
                          {
                          default: 
                            switch (paramInt)
                            {
                            default: 
                              switch (paramInt)
                              {
                              default: 
                                return null;
                              case 281: 
                                return new TransKongChengFilter();
                              case 280: 
                                return new TransXinXianFilter();
                              case 279: 
                                return new GPUImageLookupFilter("sh/rouhe_lf.png");
                              case 278: 
                                return new GPUImageLookupFilter("sh/rixi2_lf.png");
                              case 277: 
                                return new TransMeiWeiFilter();
                              case 276: 
                                return new GPUImageLookupFilter();
                              case 275: 
                                return new ImageAutoLevelGPUFilter();
                              }
                              return new DarkCornerPtuFilter();
                            case 267: 
                              return new GPUImageLookupFilter("sh/yingtaobuding_lf.png");
                            case 266: 
                              return new LollyFilter();
                            case 265: 
                              return new MilkBlueFilter();
                            case 264: 
                              return new MilkCoffeeFilter();
                            case 263: 
                              return new GradientGlareFashionFilter();
                            case 262: 
                              return new GradientGlareFondDreamFilter();
                            case 261: 
                              return new GradientAndyWarholCowFilter();
                            case 260: 
                              return new GradientPurpleYellowFilter();
                            case 259: 
                              return new MedSeaFilter();
                            }
                            return new SapporoFilter();
                          case 256: 
                            return new YoungFilter();
                          case 255: 
                            return new ChongShengFilter();
                          case 254: 
                            return new LightRedFilter();
                          case 253: 
                            return new GPUImageLookupFilter("sh/fenbi_lf.png");
                          case 252: 
                            return new GPUImageLookupFilter("sh/tianbohe_lf.png");
                          case 251: 
                            return new MilkGreenFilter();
                          case 250: 
                            return new RichYellowFilter();
                          case 249: 
                            return new RichBlueFilter();
                          case 248: 
                            return new ThursdayFilter();
                          }
                          return new NextDoorFilter();
                        case 3000: 
                          return new GPUImageLookupFilter("sh/zhigan_lf.png");
                        case 313: 
                          return new GPUImageLookupFilter("sh/hanfeng_lf.png");
                        case 312: 
                          return new GPUImageLookupFilter("sh/jiazhou_lf.png");
                        case 311: 
                          return new GPUImageLookupFilter("sh/hongkong_lf.png");
                        case 304: 
                          return new GPUImageLookupFilter("sh/peach_lf.png");
                        case 303: 
                          return new WeiZhiDaoFilters.KaFeiFilter();
                        case 302: 
                          return new WeiZhiDaoFilters.TianPinFilter();
                        case 301: 
                          return new WeiZhiDaoFilters.XinXianFilter();
                        case 300: 
                          return new WeiZhiDaoFilters.XiCanFilter();
                        case 299: 
                          return new WeiZhiDaoFilters.MeiWeiFilter();
                        case 296: 
                          return new GPUImageLookupFilter("sh/yingtaobuding_lf.png");
                        case 295: 
                          return new GPUImageLookupFilter("sh/fenhongbao_lf.png");
                        case 294: 
                          return new GPUImageLookupFilter("sh/wu_lf.png");
                        case 293: 
                          FaceBeautyAutoFilter localFaceBeautyAutoFilter = new FaceBeautyAutoFilter();
                          localFaceBeautyAutoFilter.setEffectIndex(4);
                          return localFaceBeautyAutoFilter;
                        case 292: 
                          return new GPUImageLookupFilter("sh/nuanyang_lf.png");
                        case 291: 
                          return new TianMeiZiPaiFilter();
                        case 290: 
                          return new GPUImageLookupFilter("sh/fennen_lf.png");
                        case 288: 
                          return new GPUImageLookupFilter("sh/youjiali_lf.png");
                        case 286: 
                          return new GPUImageLookupFilter("sh/tangguomeigui_lf.png");
                        case 284: 
                          return new GPUImageLookupFilter("sh/qingliang_lf.png");
                        case 272: 
                          return new TianMeiZiPaiFilter();
                        case 245: 
                          return new LightWhiteFilter();
                        case 244: 
                          return new RichRedFilter();
                        case 243: 
                          return new ThreeDFilter();
                        case 242: 
                          return new QuanMinYIngDiFilter();
                        case 241: 
                          return new PtuQingCongFilter();
                        case 240: 
                          return new PtuWenYiFanFilter();
                        case 239: 
                          return new PtuShiShang2RenFilter();
                        case 238: 
                          return new PtuShiGuangRenFilter();
                        case 237: 
                          return new PtuLengMeiRenFilter();
                        case 236: 
                          return new PtuLinjiaFilter();
                        case 235: 
                          return new AutoLevelFilter();
                        case 234: 
                          return new FengJngFilter();
                        case 233: 
                          return new MeishiFilter();
                        }
                        return new JingWuFilter();
                      case 230: 
                        return new FaceBeautyAutoFilter();
                      case 229: 
                        return new SenlinFilter();
                      case 228: 
                        return new NaichaFilter();
                      case 227: 
                        return new MenghuanFilter();
                      case 226: 
                        return new BlackWhite4Filter();
                      case 225: 
                        return new BlurHighRealFilter();
                      case 224: 
                        return new BeautysRealAutoFilter();
                      case 223: 
                        return new GaoLengFilter();
                      }
                      return new SnowFilter();
                    case 213: 
                      return new NuanHuangFilter();
                    case 212: 
                      return new MoLvFilter();
                    case 211: 
                      return new LanTuiSeFilter();
                    case 210: 
                      return new LanFilter();
                    case 209: 
                      return new JiaoPianFilter();
                    case 208: 
                      return new HuaiJiuFilter();
                    case 207: 
                      return new BlackWhiteFilter();
                    case 206: 
                      return new GaoGuangLanZiFilter();
                    case 205: 
                      return new FuGuHuangFilter();
                    }
                    return new FenFilter();
                  }
                  return new TeaMilkFilter();
                }
                return new CoffeeFilter();
              }
              return new BlackWhite3Filter();
            }
            return new FuGuFilter();
          }
          return new BlackWhite2Filter();
        }
        return new Fen2Filter();
      }
      return new ShiShangSHFilter(1);
    }
    return new ShiShangSHFilter();
  }
  
  public static BaseFilter createFilterByName(String paramString)
  {
    return createFilterById(FilterInfo.valueOf(paramString).getFilterId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.CameraFilterFactory
 * JD-Core Version:    0.7.0.1
 */