import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.avgame.gameroom.gamelist.GameListView;

public class njh
  extends RecyclerView.OnScrollListener
{
  public njh(GameListView paramGameListView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt == 1) && (!this.a.c)) {
      this.a.c = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     njh
 * JD-Core Version:    0.7.0.1
 */