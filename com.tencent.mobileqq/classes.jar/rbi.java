import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload.IHotReloadChangedObserver;

class rbi
  implements ProteusParserWithHotReload.IHotReloadChangedObserver
{
  rbi(ram paramram) {}
  
  public void onHotReloadChanged(Context paramContext, String paramString1, String paramString2)
  {
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rbi
 * JD-Core Version:    0.7.0.1
 */