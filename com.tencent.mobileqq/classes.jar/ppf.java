import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.widget.ListView;
import com.tencent.widget.ListView.OnScrollChangeListener;

public class ppf
  implements ListView.OnScrollChangeListener
{
  pne a;
  
  public ppf(pne parampne)
  {
    this.a = parampne;
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = 0;
    ReadInJoyXListView localReadInJoyXListView = null;
    paramInt1 = 0;
    for (;;)
    {
      Object localObject1 = localReadInJoyXListView;
      if (paramInt1 < this.a.a().a().a().getChildCount())
      {
        localObject1 = this.a.a().a().a().getChildAt(paramInt1);
        if ((localObject1 instanceof ProteusItemView))
        {
          localObject1 = ((ProteusItemView)localObject1).a();
          if (localObject1 != null)
          {
            localObject1 = (syq)((Container)localObject1).getTag(2131376197);
            if ((localObject1 == null) || (!((syq)localObject1).a())) {}
          }
        }
      }
      else
      {
        localReadInJoyXListView = (ReadInJoyXListView)this.a.a().a().a();
        paramInt1 = paramInt2;
        if (localObject1 != null)
        {
          paramInt1 = paramInt2;
          if (!localReadInJoyXListView.a())
          {
            ((syq)localObject1).a();
            paramInt1 = paramInt2;
          }
        }
        while (paramInt1 < localReadInJoyXListView.getChildCount())
        {
          Object localObject2 = localReadInJoyXListView.getChildAt(paramInt1);
          if ((localObject2 instanceof ProteusItemView))
          {
            localObject2 = ((ProteusItemView)localObject2).a();
            if (localObject2 != null)
            {
              localObject2 = (syq)((Container)localObject2).getTag(2131376197);
              if ((localObject2 != null) && (localObject2 != localObject1)) {
                ((syq)localObject2).b();
              }
            }
          }
          paramInt1 += 1;
        }
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ppf
 * JD-Core Version:    0.7.0.1
 */