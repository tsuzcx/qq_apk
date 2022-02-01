package com.tencent.mobileqq.emoticonview;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmoticonReportDtHelper
  extends AbstractEmoticonPanelHelper<EmoticonPanelController>
{
  public static final int FROM_AUTO = 2;
  public static final int FROM_CLICK = 0;
  public static final int FROM_SCROLL = 1;
  public static final int POST_TIME_AUTO = 102;
  public static final int POST_TIME_PAGE_SELECTED = 101;
  private static final String TAG = "EmoticonDtReportHelper";
  boolean mAutoOpenPage = false;
  private int mBusinessType = -1;
  protected int mFromType = 3;
  boolean mNeedIntercept = false;
  boolean mOnItemClicked = false;
  
  public EmoticonReportDtHelper(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  public static void bindAlbumEmotionView(View paramView, PicEmoticonInfo paramPicEmoticonInfo, int paramInt1, int paramInt2)
  {
    if ((paramView != null) && (paramInt1 >= 0) && (paramPicEmoticonInfo != null) && (paramInt2 >= 0))
    {
      VideoReport.setElementId(paramView, "em_aio_album_stickers");
      VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
      VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_NONE);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("em_aio_album_stickers");
      ((StringBuilder)localObject).append(paramPicEmoticonInfo.emoticon.eId);
      VideoReport.setElementReuseIdentifier(paramView, ((StringBuilder)localObject).toString());
      localObject = new HashMap();
      ((Map)localObject).put("order_in_album_stickers", String.valueOf(paramInt1));
      ((Map)localObject).put("id_stickers_a_set", paramPicEmoticonInfo.emoticon.eId);
      ((Map)localObject).put("order_tab_in_stickers_panel", String.valueOf(paramInt2));
      VideoReport.setElementParams(paramView, (Map)localObject);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("bindAlbumEmotionView params:");
        paramView.append(localObject.toString());
        QLog.i("EmotionReportDtImpl", 2, paramView.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("bindAlbumEmotionView, input params error, emotionOrder:");
      paramView.append(paramInt1);
      paramView.append(", tabIdx:");
      paramView.append(paramInt2);
      QLog.i("EmotionReportDtImpl", 2, paramView.toString());
    }
  }
  
  public static void bindFavoriteEmotionView(View paramView, int paramInt)
  {
    if ((paramView != null) && (paramInt >= 2))
    {
      VideoReport.setElementId(paramView, "em_aio_favorites_stickers");
      VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_ALL);
      VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_NONE);
      HashMap localHashMap = new HashMap();
      localHashMap.put("order_in_favorites_stickers", String.valueOf(paramInt - 2));
      VideoReport.setElementParams(paramView, localHashMap);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("bindFavoriteEmotionView params:");
        paramView.append(localHashMap.toString());
        QLog.i("EmotionReportDtImpl", 2, paramView.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("bindFavoriteEmotionView, input params error, emotionOrder:");
      paramView.append(paramInt);
      QLog.i("EmotionReportDtImpl", 2, paramView.toString());
    }
  }
  
  public static void bindStickersRecommendBar(View paramView, String paramString)
  {
    if ((paramView != null) && (!TextUtils.isEmpty(paramString)))
    {
      VideoReport.setElementId(paramView, "em_aio_textbox_stickers_recommend_bar");
      VideoReport.setElementClickPolicy(paramView, ClickPolicy.REPORT_NONE);
      VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
      HashMap localHashMap = new HashMap();
      localHashMap.put("text_in_textbox", paramString);
      VideoReport.setElementParams(paramView, localHashMap);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("bindStickersRecommendBar params:");
        paramView.append(localHashMap.toString());
        QLog.i("EmotionReportDtImpl", 2, paramView.toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("EmotionReportDtImpl", 2, "bindStickersRecommendBar, input params empty");
    }
  }
  
  private void updateFromType(int paramInt)
  {
    this.mFromType = paramInt;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateFromType == ");
      localStringBuilder.append(paramInt);
      QLog.d("EmoticonDtReportHelper", 2, localStringBuilder.toString());
    }
  }
  
  private void updateItemClick(boolean paramBoolean)
  {
    this.mOnItemClicked = paramBoolean;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateItemClick == ");
      localStringBuilder.append(paramBoolean);
      QLog.d("EmoticonDtReportHelper", 2, localStringBuilder.toString());
    }
  }
  
  protected void addDTReport(int paramInt1, int paramInt2)
  {
    Object localObject1 = ((EmoticonPanelController)this.mPanelController).getPanelDataList();
    if ((localObject1 != null) && (((List)localObject1).size() > paramInt1))
    {
      Object localObject3 = (EmotionPanelInfo)((List)localObject1).get(paramInt1);
      localObject1 = ((EmoticonPanelController)this.mPanelController).getPageAdapter().getAdapterFromCache((EmotionPanelInfo)localObject3);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Error!!! adapter is null!!! when post time = ");
          ((StringBuilder)localObject1).append(paramInt2);
          QLog.d("EmoticonDtReportHelper", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      localObject1 = ((BaseEmotionAdapter)localObject1).getCurrentListView();
      Object localObject2 = new HashMap();
      ((HashMap)localObject2).put("type_aio_stickers_tab_entry", String.valueOf(this.mFromType));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addDTReport mFromType = ");
        localStringBuilder.append(this.mFromType);
        localStringBuilder.append(" (0 click,1 scroll,2 auto)");
        QLog.d("EmoticonDtReportHelper", 2, localStringBuilder.toString());
      }
      int i = ((EmotionPanelInfo)localObject3).type;
      long l;
      if (i != 4)
      {
        if (i != 6)
        {
          if (i != 7)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("======== addDTReport position = ");
              ((StringBuilder)localObject1).append(paramInt1);
              ((StringBuilder)localObject1).append(" when = ");
              ((StringBuilder)localObject1).append(paramInt2);
              ((StringBuilder)localObject1).append(" type = NOTHING error!!!");
              QLog.d("EmoticonDtReportHelper", 2, ((StringBuilder)localObject1).toString());
            }
          }
          else
          {
            VideoReport.setElementId(localObject1, "em_aio_yellow_stickers_tab");
            VideoReport.setElementClickPolicy(localObject1, ClickPolicy.REPORT_NONE);
            VideoReport.setElementExposePolicy(localObject1, ExposurePolicy.REPORT_ALL);
            l = localObject3.hashCode();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("em_aio_yellow_stickers_tab");
            ((StringBuilder)localObject3).append(l);
            VideoReport.setElementReuseIdentifier(localObject1, ((StringBuilder)localObject3).toString());
            VideoReport.setElementParams(localObject1, (Map)localObject2);
            VideoReport.traverseExposure();
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("======== addDTReport position = ");
              ((StringBuilder)localObject2).append(paramInt1);
              ((StringBuilder)localObject2).append(" when = ");
              ((StringBuilder)localObject2).append(paramInt2);
              ((StringBuilder)localObject2).append(" type = TYPE_SYSTEM_AND_EMOJI View = ");
              ((StringBuilder)localObject2).append(localObject1);
              ((StringBuilder)localObject2).append("\n");
              QLog.d("EmoticonDtReportHelper", 2, ((StringBuilder)localObject2).toString());
            }
          }
        }
        else
        {
          VideoReport.setElementId(localObject1, "em_aio_album_stickers_tab");
          VideoReport.setElementClickPolicy(localObject1, ClickPolicy.REPORT_NONE);
          VideoReport.setElementExposePolicy(localObject1, ExposurePolicy.REPORT_ALL);
          l = localObject3.hashCode();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("em_aio_album_stickers_tab");
          ((StringBuilder)localObject3).append(l);
          VideoReport.setElementReuseIdentifier(localObject1, ((StringBuilder)localObject3).toString());
          VideoReport.setElementParams(localObject1, (Map)localObject2);
          VideoReport.traverseExposure();
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("======== addDTReport position = ");
            ((StringBuilder)localObject2).append(paramInt1);
            ((StringBuilder)localObject2).append(" when = ");
            ((StringBuilder)localObject2).append(paramInt2);
            ((StringBuilder)localObject2).append(" type = TYPE_BIG_EMOTICON View = ");
            ((StringBuilder)localObject2).append(localObject1);
            ((StringBuilder)localObject2).append("\n");
            QLog.d("EmoticonDtReportHelper", 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
      else
      {
        VideoReport.setElementId(localObject1, "em_aio_favorites_stickers_tab");
        VideoReport.setElementClickPolicy(localObject1, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(localObject1, ExposurePolicy.REPORT_ALL);
        l = localObject3.hashCode();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("em_aio_favorites_stickers_tab");
        ((StringBuilder)localObject3).append(l);
        VideoReport.setElementReuseIdentifier(localObject1, ((StringBuilder)localObject3).toString());
        VideoReport.setElementParams(localObject1, (Map)localObject2);
        VideoReport.traverseExposure();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("======== addDTReport position = ");
          ((StringBuilder)localObject2).append(paramInt1);
          ((StringBuilder)localObject2).append(" when = ");
          ((StringBuilder)localObject2).append(paramInt2);
          ((StringBuilder)localObject2).append(" type = TYPE_RECENT_AND_FAV View = ");
          ((StringBuilder)localObject2).append(localObject1);
          ((StringBuilder)localObject2).append("\n");
          QLog.d("EmoticonDtReportHelper", 2, ((StringBuilder)localObject2).toString());
        }
      }
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("panelDataList Error when = ");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(", position = ");
    ((StringBuilder)localObject1).append(paramInt1);
    QLog.d("EmoticonDtReportHelper", 1, ((StringBuilder)localObject1).toString());
  }
  
  public boolean getEmotionNeedRed()
  {
    BaseQQAppInterface localBaseQQAppInterface = ((EmoticonPanelController)this.mPanelController).app.getQQAppInterface();
    if (localBaseQQAppInterface == null) {
      return false;
    }
    return ((ICameraEmoRoamingManagerService)localBaseQQAppInterface.getRuntimeService(ICameraEmoRoamingManagerService.class, "")).getIsNeedShowGuide();
  }
  
  public String getTag()
  {
    return "EmoticonDtReportHelper";
  }
  
  public void initBefore()
  {
    super.initBefore();
    setBusinessType(((EmoticonPanelController)this.mPanelController).getBasePanelModel().businessType);
    setNeedIntercept(true);
  }
  
  public int[] interestedIn()
  {
    return new int[] { 3, 5, 13, 1 };
  }
  
  public void onItemTabClick(int paramInt)
  {
    List localList = ((EmoticonPanelController)this.mPanelController).getPanelDataList();
    if (localList != null)
    {
      if (paramInt >= localList.size()) {
        return;
      }
      updateItemClick(true);
      this.mAutoOpenPage = false;
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageSelected position: ");
      localStringBuilder.append(paramInt);
      QLog.d("EmoticonDtReportHelper", 2, localStringBuilder.toString());
    }
    if ((((EmoticonPanelController)this.mPanelController).getPanelDataList() != null) && (paramInt < ((EmoticonPanelController)this.mPanelController).getPanelDataList().size()))
    {
      if (this.mBusinessType != 0)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("mBusinessType not AIO, it is ");
          localStringBuilder.append(this.mBusinessType);
          QLog.d("EmoticonDtReportHelper", 2, localStringBuilder.toString());
        }
        return;
      }
      if ((this.mNeedIntercept) && (this.mAutoOpenPage))
      {
        setNeedIntercept(false);
        return;
      }
      setNeedIntercept(false);
      if (this.mAutoOpenPage)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonDtReportHelper", 2, "OnPageSelected mAutoPage = true So I return");
        }
        this.mAutoOpenPage = false;
        return;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OnPageSelected not intercept mAutoPage = false  mOnItemClicked = ");
        localStringBuilder.append(this.mOnItemClicked);
        QLog.d("EmoticonDtReportHelper", 2, localStringBuilder.toString());
      }
      if (this.mOnItemClicked) {
        updateFromType(0);
      } else {
        updateFromType(1);
      }
      updateItemClick(false);
      this.mAutoOpenPage = false;
      viewPostReport(paramInt, 101);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonDtReportHelper", 2, "mPanelController.panelDataList is null or position error ");
    }
  }
  
  public void onShow()
  {
    super.onShow();
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonDtReportHelper", 2, "OnShow");
    }
    setPanelDTParams();
    this.mAutoOpenPage = false;
  }
  
  protected void setBusinessType(int paramInt)
  {
    this.mBusinessType = paramInt;
  }
  
  protected void setNeedIntercept(boolean paramBoolean)
  {
    this.mNeedIntercept = paramBoolean;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setNeedIntercept == ");
      localStringBuilder.append(paramBoolean);
      QLog.d("EmoticonDtReportHelper", 2, localStringBuilder.toString());
    }
  }
  
  void setPanelDTParams()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void updateAutoPaged(int paramInt, boolean paramBoolean)
  {
    this.mAutoOpenPage = paramBoolean;
    updateFromType(2);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateAutoPaged position == ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" isAuto == ");
      localStringBuilder.append(paramBoolean);
      QLog.d("EmoticonDtReportHelper", 2, localStringBuilder.toString());
    }
    viewPostReport(paramInt, 102);
  }
  
  protected void viewPostReport(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("viewPostReport == when ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("EmoticonDtReportHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (((EmoticonPanelController)this.mPanelController).getPageAdapter() != null)
    {
      localObject = ((EmoticonPanelController)this.mPanelController).getPanel();
      if (localObject != null)
      {
        ((View)localObject).post(new EmoticonReportDtHelper.1(this, paramInt1, paramInt2));
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("viewPostReport panel == null!!!when time == ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("EmoticonDtReportHelper", 2, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("viewPostReport mPanelController.pageAdapter == null!!!when time == ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.d("EmoticonDtReportHelper", 2, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonReportDtHelper
 * JD-Core Version:    0.7.0.1
 */