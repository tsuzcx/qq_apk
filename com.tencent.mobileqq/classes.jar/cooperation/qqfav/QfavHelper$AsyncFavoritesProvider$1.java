package cooperation.qqfav;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.BaseApplication;

class QfavHelper$AsyncFavoritesProvider$1
  implements Runnable
{
  QfavHelper$AsyncFavoritesProvider$1(QfavHelper.AsyncFavoritesProvider paramAsyncFavoritesProvider) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.a;
    boolean bool1 = false;
    boolean bool4 = false;
    bool2 = false;
    if (localObject1 == null)
    {
      localObject1 = this.this$0;
      ((QfavHelper.AsyncFavoritesProvider)localObject1).a(false, ((QfavHelper.AsyncFavoritesProvider)localObject1).a);
      return;
    }
    long l1 = this.this$0.a.getLong("req_opt_type", -1L);
    long l2 = this.this$0.a.getLong("req_biz_type", -1L);
    Object localObject3 = this.this$0.a.getString("req_biz_key");
    Object localObject4 = this.this$0.a.getString("req_fav_uin");
    Bundle localBundle;
    if ((-1L != l1) && (-1L != l2) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject4)))
    {
      localObject1 = BaseApplication.getContext().getContentResolver();
      if (localObject1 == null)
      {
        localObject1 = this.this$0;
        ((QfavHelper.AsyncFavoritesProvider)localObject1).a(false, ((QfavHelper.AsyncFavoritesProvider)localObject1).a);
        return;
      }
      localBundle = new Bundle(this.this$0.a);
      if (1L == l1) {
        bool3 = bool4;
      }
    }
    try
    {
      localObject5 = new StringBuilder();
      bool3 = bool4;
      ((StringBuilder)localObject5).append("content://qq.favorites/biz_related/");
      bool3 = bool4;
      ((StringBuilder)localObject5).append((String)localObject4);
      bool3 = bool4;
      localObject4 = Uri.parse(((StringBuilder)localObject5).toString());
      bool3 = bool4;
      localObject5 = new StringBuilder();
      bool3 = bool4;
      ((StringBuilder)localObject5).append("");
      bool3 = bool4;
      ((StringBuilder)localObject5).append(l2);
      bool3 = bool4;
      localObject5 = ((StringBuilder)localObject5).toString();
      bool3 = bool4;
      localObject1 = ((ContentResolver)localObject1).query((Uri)localObject4, new String[] { "mUuid" }, "mBizType=? and mBizKey=?", new String[] { localObject5, localObject3 }, null);
      bool1 = bool2;
      if (localObject1 != null)
      {
        bool1 = bool2;
        bool3 = bool4;
        if (((Cursor)localObject1).moveToFirst())
        {
          bool3 = bool4;
          localObject3 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("mUuid"));
          bool1 = bool2;
          if (localObject3 != null) {
            try
            {
              localBundle.putString("rsp_fav_id", SecurityUtile.decode((String)localObject3));
              bool1 = true;
            }
            catch (Exception localException1)
            {
              bool2 = true;
              break label699;
            }
          }
        }
      }
      bool2 = bool1;
      if (localException1 == null) {
        break label704;
      }
      bool3 = bool1;
      localException1.close();
      bool2 = bool1;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject5;
        String str;
        Object localObject2;
        label699:
        bool2 = bool3;
        continue;
        bool2 = true;
      }
    }
    if (2L == l1)
    {
      bool3 = bool4;
      localObject5 = new StringBuilder();
      bool3 = bool4;
      ((StringBuilder)localObject5).append("content://qq.favorites/biz_related/");
      bool3 = bool4;
      ((StringBuilder)localObject5).append((String)localObject4);
      bool3 = bool4;
      localObject4 = Uri.parse(((StringBuilder)localObject5).toString());
      bool3 = bool4;
      localObject5 = new StringBuilder();
      bool3 = bool4;
      ((StringBuilder)localObject5).append("");
      bool3 = bool4;
      ((StringBuilder)localObject5).append(l2);
      bool2 = bool1;
      bool3 = bool4;
      if (localException1.delete((Uri)localObject4, "mBizType=? and mBizKey=?", new String[] { ((StringBuilder)localObject5).toString(), localObject3 }) > 0) {
        break label740;
      }
    }
    else
    {
      bool2 = bool1;
      if (3L == l1)
      {
        bool3 = bool4;
        str = this.this$0.a.getString("req_fav_id");
        bool2 = bool1;
        bool3 = bool4;
        if (!TextUtils.isEmpty(str))
        {
          bool3 = bool4;
          localObject5 = new ContentValues();
          bool3 = bool4;
          ((ContentValues)localObject5).put("mBizType", Long.valueOf(l2));
          bool3 = bool4;
          ((ContentValues)localObject5).put("mBizKey", (String)localObject3);
          bool3 = bool4;
          ((ContentValues)localObject5).put("mUuid", str);
          bool3 = bool4;
          localObject3 = new StringBuilder();
          bool3 = bool4;
          ((StringBuilder)localObject3).append("content://qq.favorites/biz_related/");
          bool3 = bool4;
          ((StringBuilder)localObject3).append((String)localObject4);
          bool3 = bool4;
          localObject2 = localException1.insert(Uri.parse(((StringBuilder)localObject3).toString()), (ContentValues)localObject5);
          bool2 = bool1;
          if (localObject2 != null)
          {
            break label740;
            ((Exception)localObject2).printStackTrace();
          }
        }
      }
    }
    label704:
    this.this$0.a(bool2, localBundle);
    return;
    localObject2 = this.this$0;
    ((QfavHelper.AsyncFavoritesProvider)localObject2).a(false, ((QfavHelper.AsyncFavoritesProvider)localObject2).a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqfav.QfavHelper.AsyncFavoritesProvider.1
 * JD-Core Version:    0.7.0.1
 */