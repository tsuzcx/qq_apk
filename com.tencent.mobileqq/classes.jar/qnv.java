import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

public class qnv
{
  private static int a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramContext.getResources() == null) || (TextUtils.isEmpty(paramString))) {
      return 0;
    }
    return paramContext.getResources().getIdentifier(paramString, "drawable", paramContext.getPackageName());
  }
  
  public static Drawable a(Context paramContext, String paramString, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramContext != null) {
        break label22;
      }
      localObject1 = localObject2;
    }
    label22:
    do
    {
      return localObject1;
      if (!a(paramString)) {
        break;
      }
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      paramContext = paramContext.getResources().getDrawable(2130841730);
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = paramContext;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = paramContext;
      paramContext = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
      localObject1 = paramContext;
    } while (paramInt <= 0);
    paramContext.setDecodeHandler(new bfpk(paramInt));
    return paramContext;
    if (b(paramString))
    {
      paramString = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.lastIndexOf("."));
      paramString = "qb_public_account_readinjoy_" + paramString;
      return paramContext.getResources().getDrawable(a(paramContext, paramString));
    }
    QLog.e("PTSImageUtil", 1, "[getDrawable] null, imageUrl = " + paramString);
    return null;
  }
  
  public static void a(PTSImageView paramPTSImageView, String paramString)
  {
    if ((paramPTSImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.i("PTSImageUtil", 2, "[setLocalImageDrawable], localPath = " + paramString);
    }
    int i;
    try
    {
      String str = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.lastIndexOf("."));
      str = "qb_public_account_readinjoy_" + str;
      i = a(paramPTSImageView.getContext(), str);
      if (i == 0)
      {
        QLog.e("PTSImageUtil", 1, "[setLocalImageDrawable], cannot find the resource, localPath = " + paramString);
        paramPTSImageView.setImageDrawable(new ColorDrawable(0));
        return;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("PTSImageUtil", 1, "[setLocalImageDrawable] error, e = " + paramString);
      paramPTSImageView.setImageDrawable(new ColorDrawable(0));
      return;
    }
    paramPTSImageView.setImageResource(i);
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http")) && (!paramString.startsWith("pubaccount"))) {
      return false;
    }
    return true;
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("images");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qnv
 * JD-Core Version:    0.7.0.1
 */