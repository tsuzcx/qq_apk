package io.flutter.view;

import io.flutter.util.Predicate;

class AccessibilityBridge$PredicateLabmal2
  implements Predicate<AccessibilityBridge.SemanticsNode>
{
  private AccessibilityBridge$PredicateLabmal2(AccessibilityBridge paramAccessibilityBridge) {}
  
  public boolean test(AccessibilityBridge.SemanticsNode paramSemanticsNode)
  {
    return (paramSemanticsNode != null) && (AccessibilityBridge.SemanticsNode.access$1500(paramSemanticsNode, AccessibilityBridge.Flag.HAS_IMPLICIT_SCROLLING));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.view.AccessibilityBridge.PredicateLabmal2
 * JD-Core Version:    0.7.0.1
 */