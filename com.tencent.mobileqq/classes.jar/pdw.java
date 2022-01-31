import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.wormhole.WormholeView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public class pdw
  extends pdc
{
  private sro a = new sro();
  
  private void i()
  {
    Object localObject1 = a();
    if (localObject1 == null) {
      return;
    }
    int i = ((AbsListView)localObject1).getFirstVisiblePosition();
    int k = ((AbsListView)localObject1).getLastVisiblePosition();
    label24:
    BaseArticleInfo localBaseArticleInfo;
    Object localObject2;
    StringBuilder localStringBuilder;
    if (i <= k)
    {
      localObject1 = a(i);
      if (localObject1 != null)
      {
        localBaseArticleInfo = (BaseArticleInfo)localObject1;
        localObject2 = ors.a(localBaseArticleInfo);
        int j = 0;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = ors.b(localBaseArticleInfo);
          j = 1;
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = ors.c(localBaseArticleInfo);
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ("1".equals(Uri.parse((String)localObject2).getQueryParameter("v_feeds_preload"))))
        {
          qzi.a().b((String)localObject2);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder().append("preloadFrom: ");
            if (j != 0) {
              break label205;
            }
          }
        }
      }
    }
    label205:
    for (localObject1 = "Gallery";; localObject1 = "ShortContent")
    {
      QLog.d("ViolaHandler", 2, (String)localObject1 + " and invoke webpreload data ,openUrl = " + (String)localObject2 + ";articleInfo = " + localBaseArticleInfo.toString());
      i += 1;
      break label24;
      break;
    }
  }
  
  public int a()
  {
    return 4;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560204, paramViewGroup, false);
      localView.setTag(new pdx(this.a, (WormholeView)localView, this));
    }
    paramView = (pdx)localView.getTag();
    paramViewGroup = a(paramInt);
    if ((paramViewGroup instanceof BaseArticleInfo))
    {
      paramViewGroup = (BaseArticleInfo)paramViewGroup;
      paramView.a(paramInt);
      paramView.a(paramViewGroup);
      paramView.a(paramViewGroup, paramInt);
    }
    return localView;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      i();
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a != null) {
      this.a.a(paramAbsListView);
    }
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 136;
  }
  
  public void d()
  {
    if (this.a != null) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pdw
 * JD-Core Version:    0.7.0.1
 */