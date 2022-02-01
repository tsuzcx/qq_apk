import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload.IHotReloadChangedObserver;

class sfu
  implements ProteusParserWithHotReload.IHotReloadChangedObserver
{
  sfu(sel paramsel) {}
  
  public void onHotReloadChanged(Context paramContext, String paramString1, String paramString2)
  {
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sfu
 * JD-Core Version:    0.7.0.1
 */