package cooperation.photoplus;

import android.os.Bundle;
import cooperation.photoplus.sticker.Sticker;
import eipc.EIPCResult;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

class PhotoPlusModule$1
  implements Runnable
{
  PhotoPlusModule$1(PhotoPlusModule paramPhotoPlusModule, PhotoPlusManager paramPhotoPlusManager, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.a.a();
    JSONArray localJSONArray = new JSONArray();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Sticker localSticker = (Sticker)((Iterator)localObject).next();
        if (localSticker.toJsonObject() != null) {
          localJSONArray.put(localSticker.toJsonObject());
        }
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("param_sticker_templates", localJSONArray.toString());
    this.this$0.callbackResult(this.b, EIPCResult.createSuccessResult((Bundle)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.photoplus.PhotoPlusModule.1
 * JD-Core Version:    0.7.0.1
 */