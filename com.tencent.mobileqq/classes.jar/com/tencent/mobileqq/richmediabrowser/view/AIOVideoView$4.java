package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.api.IVideoDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOVideoPresenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import java.io.File;

class AIOVideoView$4
  implements ShareActionSheet.OnItemClickListener
{
  AIOVideoView$4(AIOVideoView paramAIOVideoView, AIOVideoData paramAIOVideoData, File paramFile, int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem != null)
    {
      if (!(this.e.c instanceof Activity)) {
        return;
      }
      this.e.b.dismiss();
      int i = paramActionSheetItem.action;
      if (i != 2) {
        if (i != 3)
        {
          if (i != 6)
          {
            if (i != 27)
            {
              if (i != 39)
              {
                if (i != 54)
                {
                  if (i != 64)
                  {
                    if (i != 166)
                    {
                      if ((i == 72) || (i == 73)) {
                        break label618;
                      }
                      if (i != 126)
                      {
                        if (i == 127)
                        {
                          ((IVideoDepend)QRoute.api(IVideoDepend.class)).onQRDecodeSucceed(this.e.c, AIOVideoView.c(this.e), this.a.f, false, this.a.s, "", "", "", 2, ParamsManager.a().k(), ParamsManager.a().j());
                          AIOVideoView.a(this.e, "0X800ACB8", this.a.f);
                        }
                      }
                      else
                      {
                        ((IVideoDepend)QRoute.api(IVideoDepend.class)).onQRDecodeSucceed(this.e.c, AIOVideoView.c(this.e), this.a.f, false, this.a.s, "", "", "", 1, ParamsManager.a().k(), ParamsManager.a().j());
                        AIOVideoView.a(this.e, "0X800ACB7", this.a.f);
                      }
                    }
                    else
                    {
                      ((IMiniAppFileMaterialService)QRoute.api(IMiniAppFileMaterialService.class)).showSupportedAppList((Activity)this.e.c, this.b.getAbsolutePath());
                    }
                  }
                  else
                  {
                    AIOVideoView.b(this.e, this.a);
                    i = 7;
                    break label633;
                  }
                }
                else
                {
                  ReportController.b(null, "P_CliOper", "dwop_via", "", "0X8009BE4", "0X8009BE4", ParamsManager.a().o(), 0, "", "", "", "");
                  paramShareActionSheet = ParamsManager.a().e();
                  paramActionSheetItem = paramShareActionSheet;
                  if (TextUtils.isEmpty(paramShareActionSheet)) {
                    paramActionSheetItem = ParamsManager.a().j();
                  }
                  ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).jumpToTargetAIOPosition((Activity)this.e.c, ParamsManager.a().i(), ParamsManager.a().j(), paramActionSheetItem, this.a.c, this.a.e, this.a.f, false);
                  break label531;
                }
              }
              else {
                AIOVideoView.a(this.e, this.a, this.b, this.c, this.d);
              }
              i = 0;
              break label633;
            }
            else if ((AIOVideoView.b(this.e) != null) && (AIOVideoView.b(this.e).c()))
            {
              AIOVideoView.b(this.e).a(this.a.a);
              QQToast.makeText(this.e.c, this.e.c.getString(2131915733), 0).show();
            }
            label531:
            i = 6;
            break label633;
          }
          else
          {
            AIOVideoView.a(this.e, this.a);
            i = 3;
            break label633;
          }
        }
        else
        {
          ((IVideoDepend)QRoute.api(IVideoDepend.class)).sendToQZone((Activity)this.e.c, ParamsManager.a().k(), this.b.getAbsolutePath());
          ReportController.b(null, "dc00898", "", "", "0X8007539", "0X8007539", 0, 0, "", "", "", "");
          i = 4;
          break label633;
        }
      }
      label618:
      AIOVideoView.a(this.e, this.a, i, paramActionSheetItem);
      i = 1;
      label633:
      paramActionSheetItem = this.e.k.c.getSelectedItem();
      if ((paramActionSheetItem != null) && (paramActionSheetItem.baseData != null) && (AIOVideoData.class.isInstance(paramActionSheetItem.baseData)))
      {
        paramActionSheetItem = (AIOVideoData)paramActionSheetItem.baseData;
        if (paramActionSheetItem.m == 0)
        {
          ReportController.b(null, "dc00898", "", "", "0X8009EF9", "0X8009EF9", i, 0, "", "", "", "");
          return;
        }
        if (paramActionSheetItem.m == 1) {
          ReportController.b(null, "dc00898", "", "", "0X8009EF8", "0X8009EF8", i, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.4
 * JD-Core Version:    0.7.0.1
 */