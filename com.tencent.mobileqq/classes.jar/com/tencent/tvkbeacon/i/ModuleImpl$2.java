package com.tencent.tvkbeacon.i;

import com.tencent.tvkbeacon.core.a.c;

final class ModuleImpl$2
  implements Runnable
{
  ModuleImpl$2(ModuleImpl paramModuleImpl) {}
  
  public final void run()
  {
    ModuleImpl.access$600(this.a).a(c.a(ModuleImpl.access$700(this.a)));
    ModuleImpl.access$500(this.a).a(((c)ModuleImpl.access$600(this.a).b()).a("on_qua_date", ""));
    ModuleImpl.access$400(this.a).a(Long.valueOf(((c)ModuleImpl.access$600(this.a).b()).b("common_event_calls")));
    ModuleImpl.access$300(this.a).a(Long.valueOf(((c)ModuleImpl.access$600(this.a).b()).b("real_time_event_calls")));
    ModuleImpl.access$200(this.a).a(Long.valueOf(((c)ModuleImpl.access$600(this.a).b()).b("common_event_write_succ")));
    ModuleImpl.access$100(this.a).a(Long.valueOf(((c)ModuleImpl.access$600(this.a).b()).b("real_time_event_write_succ")));
    ModuleImpl.access$000(this.a).a(Long.valueOf(((c)ModuleImpl.access$600(this.a).b()).b("real_time_event_upload_succ")));
    ModuleImpl.access$800(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.i.ModuleImpl.2
 * JD-Core Version:    0.7.0.1
 */