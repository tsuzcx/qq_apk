import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyBiuButton;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButton;
import com.tencent.qphone.base.util.BaseApplication;

public class oam
{
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 11: 
      return 1;
    case 12: 
      return 2;
    case 13: 
      return 3;
    }
    return 4;
  }
  
  public static void a(ViewBase paramViewBase, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if ((!sht.a(paramArticleInfo)) || (paramViewBase == null)) {}
    do
    {
      return;
      if ((paramViewBase instanceof ple))
      {
        nmf.a(new nyg().a(BaseApplication.getContext()).a(11).b(3).a((AdvertisementInfo)paramArticleInfo).a());
        return;
      }
      if ((paramViewBase instanceof ReadInJoyBiuButton))
      {
        nmf.a(new nyg().a(BaseApplication.getContext()).a(13).b(3).a((AdvertisementInfo)paramArticleInfo).a());
        return;
      }
    } while (!(paramViewBase instanceof NativeButton));
    if (paramBoolean)
    {
      nmf.a(new nyg().a(BaseApplication.getContext()).a(14).b(3).a((AdvertisementInfo)paramArticleInfo).a());
      return;
    }
    nmf.a(new nyg().a(BaseApplication.getContext()).a(12).b(3).a((AdvertisementInfo)paramArticleInfo).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oam
 * JD-Core Version:    0.7.0.1
 */