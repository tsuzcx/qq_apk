package com.tencent.plato;

import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;

class PlatoAppFragment$1
  implements IPlatoManager.IRenderListener
{
  PlatoAppFragment$1(PlatoAppFragment paramPlatoAppFragment) {}
  
  public void onCreateDomFinish() {}
  
  public void onRenderFinished(String paramString)
  {
    PlatoAppFragment.access$008(this.this$0);
    long l1;
    long l2;
    if (PlatoAppFragment.access$000(this.this$0) <= 2)
    {
      if (PlatoAppFragment.access$000(this.this$0) != 1) {
        break label84;
      }
      paramString = "start_all_cost";
      l1 = System.currentTimeMillis();
      l2 = PlatoAppFragment.access$100(this.this$0);
      if (!PlatoAppFragment.access$200(this.this$0)) {
        break label90;
      }
    }
    label84:
    label90:
    for (String str = "1";; str = "0")
    {
      TroopTechReportUtils.a("plato_v1", paramString, String.valueOf(l1 - l2), str, String.valueOf(PlatoAppManager.jsLoad_status), "");
      return;
      paramString = "start_databack_cost";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.plato.PlatoAppFragment.1
 * JD-Core Version:    0.7.0.1
 */