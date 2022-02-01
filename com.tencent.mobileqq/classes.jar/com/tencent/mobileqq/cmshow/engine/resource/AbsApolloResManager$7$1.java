package com.tencent.mobileqq.cmshow.engine.resource;

class AbsApolloResManager$7$1
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  AbsApolloResManager$7$1(AbsApolloResManager.7 param7) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (this.a.b != null)
    {
      IApolloResManager.ApolloRoleInfoListener localApolloRoleInfoListener = this.a.b;
      if (paramBoolean)
      {
        paramString = new StringBuilder();
        paramString.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/");
        paramString.append(paramInt1);
        paramString = paramString.toString();
      }
      else
      {
        paramString = null;
      }
      if (paramBoolean) {
        paramArrayOfInt = "success";
      } else {
        paramArrayOfInt = "download error";
      }
      if (paramBoolean) {
        paramInt1 = 0;
      } else {
        paramInt1 = -5003;
      }
      localApolloRoleInfoListener.a(paramString, paramArrayOfInt, paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.AbsApolloResManager.7.1
 * JD-Core Version:    0.7.0.1
 */