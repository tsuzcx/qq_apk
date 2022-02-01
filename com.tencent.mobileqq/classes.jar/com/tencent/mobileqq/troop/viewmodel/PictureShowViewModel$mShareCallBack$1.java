package com.tencent.mobileqq.troop.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.kandian.biz.share.api.ShareCallBack;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/troop/viewmodel/PictureShowViewModel$mShareCallBack$1", "Lcom/tencent/mobileqq/kandian/biz/share/api/ShareCallBack;", "callback", "", "action", "", "success", "", "msg", "", "needUpdateShareNum", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PictureShowViewModel$mShareCallBack$1
  implements ShareCallBack
{
  private final boolean a(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3) || (paramInt == 9) || (paramInt == 10) || (paramInt == 12) || (paramInt == 72) || (paramInt == 73);
  }
  
  public void a(int paramInt, boolean paramBoolean, @Nullable String paramString)
  {
    if (!PictureShowViewModel.a(this.a, paramString))
    {
      if (!a(paramInt)) {
        return;
      }
      paramString = this.a;
      if (PictureShowViewModel.b(paramString, (String)PictureShowViewModel.c(paramString).getValue()))
      {
        paramInt = Integer.valueOf((String)PictureShowViewModel.c(this.a).getValue()).intValue();
        PictureShowViewModel.c(this.a).setValue(String.valueOf(paramInt + 1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.viewmodel.PictureShowViewModel.mShareCallBack.1
 * JD-Core Version:    0.7.0.1
 */