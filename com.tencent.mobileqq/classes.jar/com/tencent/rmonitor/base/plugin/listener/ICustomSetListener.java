package com.tencent.rmonitor.base.plugin.listener;

import com.tencent.rmonitor.base.meta.CustomMeta;
import com.tencent.rmonitor.base.meta.IssueDetails;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/plugin/listener/ICustomSetListener;", "Lcom/tencent/rmonitor/base/plugin/listener/IBaseListener;", "onCustomFieldSet", "Lcom/tencent/rmonitor/base/meta/CustomMeta;", "issueDetails", "Lcom/tencent/rmonitor/base/meta/IssueDetails;", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public abstract interface ICustomSetListener
  extends IBaseListener
{
  @NotNull
  public abstract CustomMeta onCustomFieldSet(@NotNull IssueDetails paramIssueDetails);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.plugin.listener.ICustomSetListener
 * JD-Core Version:    0.7.0.1
 */