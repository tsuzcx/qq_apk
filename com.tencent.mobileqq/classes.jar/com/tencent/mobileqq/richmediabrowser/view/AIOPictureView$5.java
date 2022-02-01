package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import java.io.File;

class AIOPictureView$5
  implements ShareActionSheet.OnItemClickListener
{
  AIOPictureView$5(AIOPictureView paramAIOPictureView, AIOPictureData paramAIOPictureData, RichMediaBrowserInfo paramRichMediaBrowserInfo, File paramFile) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    int i = paramActionSheetItem.action;
    paramShareActionSheet = paramActionSheetItem.argus;
    if (i != 72) {
      this.d.b.dismiss();
    }
    if (i != 2) {
      if (i != 6)
      {
        if (i != 9)
        {
          if (i != 27)
          {
            if (i != 39)
            {
              if (i != 48) {
                if (i != 66) {
                  if (i != 166) {
                    if ((i == 72) || (i == 73)) {
                      break label628;
                    }
                  }
                }
              }
              switch (i)
              {
              default: 
                break;
              case 56: 
                paramActionSheetItem = new Intent();
                ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).onQRDecodeSucceed(this.d.c, this.d.p, this.a.f, this.a.A, this.a.z, this.a.u, this.a.y, this.a.r, 2, ParamsManager.a().k(), ParamsManager.a().j(), paramActionSheetItem);
                i = 10;
                break;
              case 55: 
                paramActionSheetItem = new Intent();
                ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).onQRDecodeSucceed(this.d.c, this.d.p, this.a.f, this.a.A, this.a.z, this.a.u, this.a.y, this.a.r, 1, ParamsManager.a().k(), ParamsManager.a().j(), paramActionSheetItem);
                ReportController.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
                i = 9;
                break;
              case 54: 
                AIOPictureView.d(this.d, this.a);
                i = 7;
                break;
              case 52: 
                if ((this.d.c instanceof Activity)) {
                  ((IOCR)QRoute.api(IOCR.class)).startOcrPerformFragment((Activity)this.d.c, this.c.getAbsolutePath(), 1, this.a.f, this.a.u);
                }
                i = 8;
                break;
              case 51: 
                AIOPictureView.b(this.d, this.a);
                i = 5;
                break;
              case 50: 
                AIOPictureView.a(this.d, this.b);
                i = 4;
                break label643;
                AIOPictureView.a(this.d, this.c);
                break;
                AIOPictureView.e(this.d, this.a);
                break;
                AIOPictureView.a(this.d, this.a);
                i = 12;
                break;
              }
            }
            else
            {
              AIOPictureView.a(this.d, this.a, this.b, this.c);
              i = 2;
              break label643;
            }
          }
          else
          {
            AIOPictureView.c(this.d, this.a);
            i = 6;
            break label643;
          }
        }
        else
        {
          ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).sharePicToWXFromPeak(this.c.getPath(), this.d.c);
          ReportController.b(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
        }
        i = 0;
        break label643;
      }
      else
      {
        AIOPictureView.a(this.d, this.b, this.c);
        i = 3;
        break label643;
      }
    }
    label628:
    AIOPictureView.a(this.d, i, paramActionSheetItem, this.b);
    i = 1;
    label643:
    ReportController.b(null, "dc00898", "", "", "0X8009EF6", "0X8009EF6", i, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.5
 * JD-Core Version:    0.7.0.1
 */