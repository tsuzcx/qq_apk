package com.tencent.mobileqq.nearby.business;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.nearby.dating.IDatingUtil;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.List;

public class NearbyCardObserver
  implements BusinessObserver
{
  public void a() {}
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString) {}
  
  protected void a(String paramString, int paramInt) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, List<Object> paramList1, List<Object> paramList2, String paramString1, int paramInt3, int paramInt4, String paramString2) {}
  
  protected void a(boolean paramBoolean, int paramInt, List<Object> paramList, List<String> paramList1) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, byte[] paramArrayOfByte, String paramString) {}
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void a(boolean paramBoolean1, Object paramObject, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, Object paramObject, boolean paramBoolean2, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, String paramString1, List<Object> paramList, String paramString2, int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean, ArrayList<Object> paramArrayList, int paramInt) {}
  
  protected void a(boolean paramBoolean, ArrayList<Object> paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected void b(boolean paramBoolean) {}
  
  protected void b(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  protected void b(boolean paramBoolean, ArrayList<Object> paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            boolean bool1;
            label306:
            Object localObject1;
            if (paramInt != 9)
            {
              if (paramInt != 10)
              {
                if (paramInt != 13)
                {
                  if (paramInt != 32)
                  {
                    if (paramInt != 40)
                    {
                      if (paramInt != 57)
                      {
                        if (paramInt != 16)
                        {
                          if (paramInt != 17)
                          {
                            if (paramInt != 60)
                            {
                              if (paramInt != 61)
                              {
                                int j = -1;
                                int i;
                                int k;
                                switch (paramInt)
                                {
                                default: 
                                  return;
                                case 51: 
                                  if ((paramBoolean) && ((paramObject instanceof Object[])))
                                  {
                                    paramObject = (Object[])paramObject;
                                    bool1 = ((Boolean)paramObject[1]).booleanValue();
                                    a(paramBoolean, paramObject[0], bool1);
                                    return;
                                  }
                                  a(paramBoolean, paramObject, false);
                                  return;
                                case 50: 
                                  if (paramObject != null)
                                  {
                                    paramObject = (Object[])paramObject;
                                    if ((paramObject != null) && (paramObject.length == 5))
                                    {
                                      if ((paramObject[1] instanceof Integer)) {
                                        j = ((Integer)paramObject[1]).intValue();
                                      } else {
                                        j = -1;
                                      }
                                      if ((paramObject[2] instanceof Integer)) {
                                        paramInt = ((Integer)paramObject[2]).intValue();
                                      } else {
                                        paramInt = -1;
                                      }
                                      if ((paramObject[3] instanceof Integer)) {
                                        i = ((Integer)paramObject[3]).intValue();
                                      } else {
                                        i = -1;
                                      }
                                      if ((paramObject[4] instanceof Integer))
                                      {
                                        k = ((Integer)paramObject[4]).intValue();
                                        break label306;
                                      }
                                    }
                                    else
                                    {
                                      paramInt = -1;
                                      i = -1;
                                    }
                                    k = -1;
                                    b(paramBoolean, (ArrayList)paramObject[0], j, paramInt, i, k);
                                    return;
                                  }
                                  b(false, null, -1, -1, -1, -1);
                                  return;
                                case 49: 
                                  a(paramBoolean);
                                  return;
                                case 48: 
                                  paramObject = (Object[])paramObject;
                                  if ((paramObject != null) && (paramObject.length == 5))
                                  {
                                    if ((paramObject[1] instanceof Integer)) {
                                      paramInt = ((Integer)paramObject[1]).intValue();
                                    } else {
                                      paramInt = -1;
                                    }
                                    if ((paramObject[2] instanceof Integer)) {
                                      i = ((Integer)paramObject[2]).intValue();
                                    } else {
                                      i = -1;
                                    }
                                    if ((paramObject[3] instanceof Integer)) {
                                      j = ((Integer)paramObject[3]).intValue();
                                    } else {
                                      j = -1;
                                    }
                                    if ((paramObject[4] instanceof Integer)) {
                                      k = ((Integer)paramObject[4]).intValue();
                                    } else {
                                      k = -1;
                                    }
                                    a(paramBoolean, (ArrayList)paramObject[0], paramInt, i, j, k);
                                    return;
                                  }
                                  a(false, null, -1, -1, -1, -1);
                                  return;
                                case 47: 
                                  if (paramObject != null)
                                  {
                                    a(paramBoolean, paramObject);
                                    return;
                                  }
                                  a(false, null);
                                  return;
                                }
                                b(paramBoolean);
                                return;
                              }
                              if ((paramBoolean) && ((paramObject instanceof Object[])))
                              {
                                paramObject = (Object[])paramObject;
                                a(((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), ((Integer)paramObject[6]).intValue(), ((Integer)paramObject[7]).intValue(), (String)paramObject[8]);
                              }
                            }
                            else if ((paramBoolean) && ((paramObject instanceof Object[])))
                            {
                              paramObject = (Object[])paramObject;
                              a(((Boolean)paramObject[0]).booleanValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), ((Integer)paramObject[6]).intValue(), (String)paramObject[7]);
                            }
                          }
                          else if ((paramObject instanceof Object[]))
                          {
                            paramObject = (Object[])paramObject;
                            a(paramBoolean, (ArrayList)paramObject[0], ((Integer)paramObject[1]).intValue());
                          }
                        }
                        else
                        {
                          if ((paramObject instanceof String)) {
                            paramObject = (String)paramObject;
                          } else {
                            paramObject = "";
                          }
                          a(paramBoolean, paramObject);
                        }
                      }
                      else if ((paramObject instanceof Object[]))
                      {
                        paramObject = (Object[])paramObject;
                        paramInt = ((Integer)paramObject[0]).intValue();
                        if (paramObject.length >= 3)
                        {
                          localObject1 = (List)paramObject[2];
                          a(paramBoolean, paramInt, (List)paramObject[1], (List)localObject1);
                          return;
                        }
                        a(paramBoolean, paramInt, (List)paramObject[1], null);
                      }
                    }
                    else if (paramObject != null)
                    {
                      paramObject = (Object[])paramObject;
                      a(paramBoolean, (String)paramObject[0], (mobile_sub_get_cover_rsp)paramObject[1]);
                    }
                  }
                  else if ((paramObject instanceof Bundle))
                  {
                    paramObject = (Bundle)paramObject;
                    if ((paramObject.getInt("favoriteSource") != 43) && (paramObject.getInt("favoriteSource") != 51))
                    {
                      a(paramBoolean, paramObject.getString("selfUin"), paramObject.getString("targetUin"), paramObject.getInt("iCount", 0), paramObject.getInt("from", 0));
                      return;
                    }
                    b(paramBoolean, paramObject.getString("selfUin"), paramObject.getString("targetUin"), paramObject.getInt("toplist_type"), paramObject.getInt("iCount", 0));
                  }
                }
                else if ((paramBoolean) && (paramObject != null))
                {
                  paramObject = (Object[])paramObject;
                  a(paramBoolean, ((Long)paramObject[0]).longValue(), (String)paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
                }
              }
              else if ((paramObject instanceof Object[]))
              {
                paramObject = (Object[])paramObject;
                a((String)paramObject[0], ((Integer)paramObject[1]).intValue());
              }
            }
            else
            {
              Object localObject2 = (Object[])paramObject;
              if ((paramBoolean) && (localObject2 != null) && (localObject2.length == 6))
              {
                long l = ((Long)localObject2[0]).longValue();
                bool1 = ((Boolean)localObject2[1]).booleanValue();
                boolean bool2 = ((Boolean)localObject2[2]).booleanValue();
                paramObject = (byte[])localObject2[3];
                localObject1 = (String)localObject2[4];
                localObject2 = (String)localObject2[5];
                a(paramBoolean, l, bool1, bool2, paramObject, (String)localObject1);
                ((IDatingUtil)QRoute.api(IDatingUtil.class)).updateConfigurableShowloveWord((String)localObject2);
                return;
              }
              a(false, 0L, false, false, null, null);
            }
          }
          else
          {
            paramObject = (Object[])paramObject;
            a(paramBoolean, (String)paramObject[0], (List)paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
          }
        }
        else
        {
          paramObject = (Object[])paramObject;
          a(paramBoolean, paramObject[0], ((Boolean)paramObject[1]).booleanValue(), (String)paramObject[2]);
        }
      }
      else
      {
        paramObject = (Object[])paramObject;
        a();
      }
    }
    else
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), (List)paramObject[2], (List)paramObject[3], (String)paramObject[4], ((Integer)paramObject[5]).intValue(), ((Integer)paramObject[6]).intValue(), (String)paramObject[7]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.business.NearbyCardObserver
 * JD-Core Version:    0.7.0.1
 */