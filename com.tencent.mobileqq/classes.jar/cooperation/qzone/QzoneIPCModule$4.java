package cooperation.qzone;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager.ImgUpdateListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;

final class QzoneIPCModule$4
  implements IStickerRecManager.ImgUpdateListener
{
  public void onImgUpdated(List<IStickerRecEmoticon> paramList, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      paramString2 = new StringBuilder();
      paramString2.append("OnImgUpdated: empty data or text ");
      paramString2.append(paramString1);
      paramString2.append(" ");
      if (paramList == null) {
        paramList = "null";
      } else {
        paramList = Integer.valueOf(paramList.size());
      }
      paramString2.append(paramList);
      QLog.i("QzoneIPCModule", 2, paramString2.toString());
      return;
    }
    paramList = QzoneIPCModule.parseSticker2Json(paramList);
    if (paramList == null)
    {
      QLog.i("QzoneIPCModule", 2, "OnImgUpdated: failed to parse img data");
      return;
    }
    QzoneIPCModule.getInstance().onGetStickerRecResp(paramString1, paramList.toString(), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneIPCModule.4
 * JD-Core Version:    0.7.0.1
 */