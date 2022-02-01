package com.tencent.qmsp.sdk.b;

import org.json.JSONObject;

class g$a
  implements f
{
  g$a(g paramg) {}
  
  public void a(int paramInt1, String paramString, int paramInt2, JSONObject paramJSONObject, e parame)
  {
    for (;;)
    {
      try
      {
        paramJSONObject = g.a(this.a, 8, paramJSONObject);
        if (paramJSONObject != null)
        {
          paramString = a.a(paramInt1, paramString, paramInt2, paramJSONObject);
          if (paramString.b == 0)
          {
            if ((paramString.a != null) && ((paramString.a instanceof JSONObject)))
            {
              paramString = g.a(this.a, 9, paramString.a);
              parame.a(161, paramString);
            }
          }
          else {
            parame.a(162, paramString.a);
          }
        }
        else
        {
          parame.a(163, null);
          return;
        }
      }
      catch (Exception paramString)
      {
        com.tencent.qmsp.sdk.f.g.b(g.a(this.a), 0, "send fail！");
        parame.a(162, null);
        paramString.printStackTrace();
        return;
      }
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.b.g.a
 * JD-Core Version:    0.7.0.1
 */